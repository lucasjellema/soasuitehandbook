package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class CarMovementController implements RunnableBean, StreamSource{
    public CarMovementController() {
        super();
    }
    private static final int SLEEP_MILLIS = 120;    
    
    private boolean suspended;

    private TreeSet<ParkedCar> parkedCars = new TreeSet<ParkedCar>(new ParkedCarLeaveTimeComparator()) ;

    private StreamSender eventSender;
    private static Random rand = new Random();


    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
     
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        suspended = false;
        while (!isSuspended()) { // Generate messages forever...

            generateCarMovementEvent();

            try {
                synchronized (this) {
                    wait(SLEEP_MILLIS * randInt(1, 5)/2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    private void generateCarMovementEvent() {
        
        
        ParkedCar car = new ParkedCar();
        car.setCarparkIdentifier("1");
        parkedCars.add(car);
        CarMovementEvent event = new CarMovementEvent();
        event.setEntryOrExit(1);
        event.setCarparkIdentifier("1");
        event.setLicencePlate(car.getlicencePlate());
        event.setArrivalTime(car.getArrivalTime());
        eventSender.sendInsertEvent(event);
        long now = new Date().getTime();
        if (parkedCars.first().getTimeToLeave()< now) {
            // find all parkedCars that should leave by  now
            Iterator<ParkedCar> itr=new TreeSet(parkedCars).iterator(); //create clone in order to be able to remove elements from original parkedCars treeset
            while(itr.hasNext()){
                ParkedCar parkedCar=itr.next();
                if (parkedCar.getTimeToLeave()> now) {
                    // as soon as we find a car that does not yet have to leave, we can stop processing the parked cars:
                    // because they are ordered on time to leave, all subsequent cars will not yet have to leave
                    break;
                }
                CarMovementEvent exitEvent = new CarMovementEvent();
                exitEvent.setEntryOrExit(-1);
                exitEvent.setLicencePlate(parkedCar.getlicencePlate());
                exitEvent.setCarparkIdentifier(parkedCar.getCarparkIdentifier());
                    eventSender.sendInsertEvent(exitEvent);
                
                parkedCars.remove(parkedCar);
                
            }   
            }
    
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSource#setEventSender(com.bea.wlevs.ede.api.StreamSender)
     */
    public void setEventSender(StreamSender sender) {
        eventSender = sender;
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

    private class ParkedCar {
        
        String licencePlate;
        long   timeToLeave;
        long   arrivalTime;
        private String carparkIdentifier;

        public void setCarparkIdentifier(String carparkIdentifier) {
            this.carparkIdentifier = carparkIdentifier;
        }

        public String getCarparkIdentifier() {
            return carparkIdentifier;
        }

        public ParkedCar() {
            
            this.licencePlate=randChar()+randChar()+"-"+randInt(1,999)+"-"+randChar()+randChar();
            // currently the staying time for a car is maximum 50 seconds
            this.timeToLeave = new Date().getTime()+ 5000 * randInt(1, 10);
            // 1 in 100 cars will be an abandoned car that has to be towed
            if (randInt(1,100)==1) {
                // abandoned cars have a timeToLeave very far in the future
                this.timeToLeave = new Date().getTime()+ 500000000 ;  
                System.out.println("******  Here is a car that will be abandoned : "+this.licencePlate);
            }
            this.arrivalTime = new Date().getTime();
        }

        public void setArrivalTime(long arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }

        public void setlicencePlate(String licencePlate) {
            this.licencePlate = licencePlate;
        }

        public String getlicencePlate() {
            return licencePlate;
        }

        public void setTimeToLeave(long timeToLeave) {
            this.timeToLeave = timeToLeave;
        }

        public long getTimeToLeave() {
            return timeToLeave;
        }

        private String randChar() {
            return new Character((char) randInt(65,90)).toString();
        }
    }

    private class ParkedCarLeaveTimeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            // TODO Implement this method
            return Long.compare(((ParkedCar)o1).getTimeToLeave(),((ParkedCar)o2).getTimeToLeave());
        }
    }
}
