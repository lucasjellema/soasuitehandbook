package saibot.airport.security;

import java.util.Hashtable;

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

public class JmsQueueListener implements MessageListener{
    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    public final static String JMS_FACTORY = "jms/finance/FinanceConnectionFactory";

    public final static String QUEUE = "jms/security/SuspectedCreditCardEventsQueue";

    private QueueConnectionFactory qconFactory;

    private QueueConnection qcon;

    private QueueSession qsession;

    private QueueReceiver qreceiver;

    private Queue queue;

    private boolean quit = false;

    public void onMessage(Message msg)

    {

        try {

            String msgText;

            if (msg instanceof MapMessage) {

                MapMessage mess = ((MapMessage) msg);
                System.out.println("CreditCardNumber "+ mess.getString("creditCardNumber"));
                System.out.println("Shops "+ mess.getString("listOfShops"));
                System.out.println("Purchase Amounts "+ mess.getString("listOfAmounts"));
                System.out.println("durationOfShoppingSpree "+ mess.getFloat("durationOfShoppingSpree")*1E-09+" seconds ");
                System.out.println("Total Sum "+ mess.getFloat("totalSum"));

            } ;

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

        }

    }

    public void init(Context ctx, String queueName)

        throws NamingException, JMSException

    {

        qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);

        qcon = qconFactory.createQueueConnection();

        qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        queue = (Queue) ctx.lookup(queueName);

        qreceiver = qsession.createReceiver(queue);

        qreceiver.setMessageListener((MessageListener) this);

        qcon.start();

    }

    public void close() throws JMSException

    {

        qreceiver.close();

        qsession.close();

        qcon.close();

    }

    public static void main(String[] args) throws Exception {

        InitialContext ic = getInitialContext();

        JmsQueueListener qr = new JmsQueueListener();

        qr.init(ic, QUEUE);

        System.out.println("JMS Ready To Receive Messages (To quit, send a \"quit\" message).");

        synchronized (qr) {

            while (!qr.quit) {

                try {

                    qr.wait();

                } catch (InterruptedException ie) {
                }

            }

        }

        qr.close();

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
