package saibot.airport.security.monitor.jms;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

import javax.jms.QueueReceiver;
import javax.jms.QueueSession;

import javax.jms.Session;
import javax.jms.TextMessage;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.adf.share.logging.ADFLogger;


public class CreditCardQueueListener implements MessageListener {

    public final static String JMS_FACTORY = "jms/finance/FinanceConnectionFactory";
    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String QUEUE = "jms/security/SuspectedCreditCardEventsQueue";

    private QueueConnectionFactory qconFactory;
    private QueueConnection qcon;
    private QueueSession qsession;
    private QueueReceiver qreceiver;
    private Queue queue;
    private boolean quit = false;


    public CreditCardQueueListener() {
        try {
            _logger.severe("Constructor ");
            init(QUEUE);
        } catch (JMSException e) {
            _logger.severe("JMSException " + e.getMessage());
        } catch (NamingException e) {
            _logger.severe("NamingException " + e.getMessage());
        }
    }
    private static ADFLogger _logger = ADFLogger.createADFLogger(CreditCardQueueListener.class);
    private static List<SuspiciousCreditCardEventHandler> eventHandlers = new ArrayList<SuspiciousCreditCardEventHandler>();
    private static List<SummaryCreditCardEventHandler> summaryEventHandlers = new ArrayList<SummaryCreditCardEventHandler>();


    public static List<SummaryCreditCardEventHandler> getSummaryEventHandlers() {
        return summaryEventHandlers;
    }

    public static List<SuspiciousCreditCardEventHandler> getEventHandlers() {
        return eventHandlers;
    }

    public void onMessage(Message msg) {
        try {
            _logger.severe("Received a JMS message from the queue " + msg);
            String msgText;
            if (msg instanceof MapMessage) {
                MapMessage mess = ((MapMessage) msg);
                _logger.severe("Processed message, now creating creditcard event");
                String messageType = mess.getString("messageType");
                if ("SuspectCreditCardEvent".equalsIgnoreCase(messageType)) {
                    SuspiciousCreditCardEvent e =
                        new SuspiciousCreditCardEvent(mess.getString("creditCardNumber"), mess.getFloat("totalSum"),
                                            mess.getString("listOfShops"), mess.getString("listOfAmounts"));
                    for (SuspiciousCreditCardEventHandler handler : getEventHandlers()) {
                        handler.handleEvent(e);
                        _logger.severe("Sent message to a handler");
                    }
                }
                if ("CreditCardPurchasesSummaryEvent".equalsIgnoreCase(messageType)) {
                    _logger.severe("received a summary event ");
                    Long numberOfPurchases = mess.getLong("numberOfPurchases");
                    Double sumAmounts = mess.getDouble("sumAmounts");
                    Integer numberOfCreditCards = mess.getInt("numberOfCreditCards");
                    Integer numberOfShops = mess.getInt("numberOfShops");
                    SummaryCreditCardEvent scce = new SummaryCreditCardEvent(sumAmounts, numberOfPurchases, numberOfCreditCards, numberOfShops);
                    _logger.severe("summary event #purchases " + numberOfPurchases+" now process handlers "+summaryEventHandlers.size() );
                    
                    for (SummaryCreditCardEventHandler handler:summaryEventHandlers) {
                        handler.handleEvent(scce);
                        _logger.severe("Sent SUMMARY message to a SUMMARY handler");
                    }
                }
            }
            ;
            if (msg instanceof TextMessage) {
                msgText = ((TextMessage) msg).getText();
            } else {
                msgText = msg.toString();
            }
            System.out.println("Message Received: " + msgText);
            if (msgText.equalsIgnoreCase("quit")) {
                synchronized (this) {
                    quit = true;
                    this.notifyAll(); // Notify main thread to quit
                }
            }
        } catch (JMSException jmse) {
            System.err.println("An exception occurred: " + jmse.getMessage());
            _logger.severe("An Exceptionn  " + jmse.getMessage());
        }
    }

    public void init(String queueName) throws NamingException, JMSException {
        InitialContext ctx = getInitialContext();
        qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
        qcon = qconFactory.createQueueConnection();
        qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = (Queue) ctx.lookup(queueName);
        qreceiver = qsession.createReceiver(queue);
        qreceiver.setMessageListener((MessageListener) this);
        qcon.start();
    }


    public void close() throws JMSException {
        qreceiver.close();
        qsession.close();
        qcon.close();
    }


    private static InitialContext getInitialContext()

        throws NamingException

    {

        Hashtable<String, String> env = new Hashtable<String, String>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);

        env.put(Context.PROVIDER_URL, "t3://soa2admin2:8001/");

        return new InitialContext(env);

    }
}

