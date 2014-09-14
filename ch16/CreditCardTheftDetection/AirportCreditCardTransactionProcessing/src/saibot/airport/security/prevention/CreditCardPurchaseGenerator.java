package saibot.airport.security.prevention;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import saibot.airport.security.prevention.event.CreditCardPurchaseEvent;

public class CreditCardPurchaseGenerator implements RunnableBean, StreamSource{
    
    private StreamSender eventSender;

    private static final int SLEEP_MILLIS = 100;
    private static Random rand = new Random();
    private boolean suspended;
    private List<CreditCardPurchaseEvent> purchases = new ArrayList<CreditCardPurchaseEvent>();    
    private int index = 0;

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.     
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    

    public void setEventSender1(StreamSender eventSender) {
        this.eventSender = eventSender;
    }

    public StreamSender getEventSender() {
        return eventSender;
    }

    public CreditCardPurchaseGenerator() {
        super();
        purchases.add( new CreditCardPurchaseEvent(349.99f, "1234-9182-7281-1617", 3));
        purchases.add( new CreditCardPurchaseEvent(480.00f, "1234-9182-7281-1617", 23));
        purchases.add( new CreditCardPurchaseEvent(220.46f, "1234-9182-7281-1617", 27));
        purchases.add( new CreditCardPurchaseEvent(90.00f, "4718-9182-7281-1617", 2));
        purchases.add( new CreditCardPurchaseEvent(400.99f, "4718-9182-7281-1617", 13));
        purchases.add( new CreditCardPurchaseEvent(249.99f, "4718-9182-7281-1617", 11));
        purchases.add( new CreditCardPurchaseEvent(489.50f, "4718-9182-7281-1617", 25));
        purchases.add( new CreditCardPurchaseEvent(239.99f, "7123-9182-7281-1617",5));
        purchases.add( new CreditCardPurchaseEvent(210.99f, "7123-9182-7281-1617", 13));
        purchases.add( new CreditCardPurchaseEvent(499.00f, "7123-9182-7281-1617", 33));
        purchases.add( new CreditCardPurchaseEvent(420.25f, "7123-9182-7281-1617", 23));
        purchases.add( new CreditCardPurchaseEvent(300f, "7182-9182-7281-1617", 36));
        purchases.add( new CreditCardPurchaseEvent(320.25f, "7183-9182-7281-1617", 23));
        purchases.add( new CreditCardPurchaseEvent(400f, "7183-9182-7281-1617", 36));
        purchases.add( new CreditCardPurchaseEvent(239.99f, "4123-9182-7281-1617",5));
        purchases.add( new CreditCardPurchaseEvent(210.99f, "4123-9182-7281-1617", 1));
        purchases.add( new CreditCardPurchaseEvent(499.00f, "4123-9182-7281-1617", 33));
        purchases.add( new CreditCardPurchaseEvent(420.25f, "4123-9182-7281-1617", 29));
        purchases.add( new CreditCardPurchaseEvent(239.99f, "7654-9182-7281-1617",7));
        purchases.add( new CreditCardPurchaseEvent(810.99f, "7654-9182-7281-1617", 16));
        purchases.add( new CreditCardPurchaseEvent(499.00f, "7654-9182-7281-1617", 31));
        purchases.add( new CreditCardPurchaseEvent(420.25f, "7654-9182-7281-1617", 26));
        purchases.add( new CreditCardPurchaseEvent(249.99f, "2234-9182-7281-1617", 13));
        purchases.add( new CreditCardPurchaseEvent(349.99f, "2234-9182-7281-1617", 13));
        purchases.add( new CreditCardPurchaseEvent(480.00f, "2234-9182-7281-1617", 18));
        purchases.add( new CreditCardPurchaseEvent(220.46f, "2234-9182-7281-1617", 27));
        purchases.add( new CreditCardPurchaseEvent(20.46f, "8834-9182-7281-1617", 27));
        purchases.add( new CreditCardPurchaseEvent(320.46f, "8834-6799-3212-1617", 27));
        purchases.add( new CreditCardPurchaseEvent(349.99f, "1239-9182-7281-1617", 3));
        purchases.add( new CreditCardPurchaseEvent(480.00f, "1239-9182-7281-1617", 23));
        purchases.add( new CreditCardPurchaseEvent(220.46f, "1239-9182-7281-1617", 27));
        purchases.add( new CreditCardPurchaseEvent(49.99f, "3579-9182-7281-1617", 3));
        purchases.add( new CreditCardPurchaseEvent(180.00f, "3579-9182-7281-1617", 23));
        purchases.add( new CreditCardPurchaseEvent(820.46f, "3579-9182-7281-1617", 27));
           
    }

    @Override
    public void run() {
        suspended = false;
        while (!isSuspended()) { // Generate messages forever...

            generateCreditCardPurchaseEvent();

            try {
                synchronized (this) {
                    wait(randInt(SLEEP_MILLIS/2, SLEEP_MILLIS*2));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.SuspendableBean#suspend()
     */
    public synchronized void suspend() {
        suspended = true;
    }

    private synchronized boolean isSuspended() {
        return suspended;
    }
    @Override
    public void setEventSender(StreamSender streamSender) {
        eventSender = streamSender;
    }

    private void generateCreditCardPurchaseEvent() {
        
        CreditCardPurchaseEvent event = new CreditCardPurchaseEvent();
        
        if (randInt(1, 100)<3) {
            if (index< purchases.size())
          event = purchases.get(index++);            
        }
        else {
          event.setAmount(new Integer(randInt(0, 850)).floatValue());
          event.setCreditCardNumber("1234-"+randInt(104, 970)+"2-7281-"+randInt(11, 98)+"17");
          event.setShopIdentifier(randInt(1,45));
        }
        eventSender.sendInsertEvent(event);
    }
}
