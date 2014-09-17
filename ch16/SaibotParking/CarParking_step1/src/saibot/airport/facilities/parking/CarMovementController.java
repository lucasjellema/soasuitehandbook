package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.Random;

import saibot.airport.facilities.parking.event.CarMovementEvent;

public class CarMovementController implements RunnableBean, StreamSource {
    
    private static final int SLEEP_MILLIS = 100;
    private boolean suspended;
    private StreamSender eventSender;
    private static Random rand = new Random();

    public static int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    private String randChar() {
        return new Character((char) randInt(65, 90)).toString();
    }

    public void run() {
      suspended = false;
      while (!isSuspended()) { // Generate messages forever...
        generateCarMovementEvent();
        try { synchronized (this) {
              wait(SLEEP_MILLIS * randInt(1, 5) / 2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
    }

    private void generateCarMovementEvent() {
      CarMovementEvent event = new CarMovementEvent();
      event.setEntryOrExit(1);
      event.setCarparkIdentifier("1");
      event.setLicencePlate(randChar() + randChar() + "-" + randInt(1, 999) + "-" + randChar() + randChar());
      eventSender.sendInsertEvent(event);
    }

    public void setEventSender(StreamSender sender) {
        eventSender = sender;
    }

    public synchronized void suspend() {
        suspended = true;
    }

    private synchronized boolean isSuspended() {
        return suspended;
    }
}