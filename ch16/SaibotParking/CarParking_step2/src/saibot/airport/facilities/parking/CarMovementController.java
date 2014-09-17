package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import saibot.airport.facilities.parking.event.CarMovementEvent;

public class CarMovementController implements RunnableBean, StreamSource {
    public CarMovementController() {
        super();
        Map<String, Object> all =  new CarParkCacheLoader().loadAll();
        Set<String> keySet = all.keySet();
        for (String key:keySet) {
            carparks.add((CarPark)all.get(key));
        }
        // load a treeset for each carpark
        for (CarPark park : carparks) {
            parkedCars.add(new TreeSet<ParkedCar>(new ParkedCarLeaveTimeComparator()));
        }
    }
    private static final int SLEEP_MILLIS = 100;

    private boolean suspended;

    private List<TreeSet<ParkedCar>> parkedCars = new ArrayList<TreeSet<ParkedCar>>();

    private StreamSender eventSender;
    private static Random rand = new Random();
    private  List<CarPark> carparks = new ArrayList<CarPark>();


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
                    wait(SLEEP_MILLIS * randInt(1, 5) / 2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void generateCarMovementEvent() {
        int carparkSeq = randInt(0, carparks.size() - 1);
        // if the carpark will hold one more car
        if (parkedCars.get(carparkSeq).size() < carparks.get(carparkSeq).getCapacity()) {
            ParkedCar car = new ParkedCar();
            car.setCarparkIdentifier(carparks.get(carparkSeq).getIdentifier());
            parkedCars.get(carparkSeq).add(car);
            CarMovementEvent event = new CarMovementEvent();
            event.setEntryOrExit(1);
            event.setCarparkIdentifier(carparks.get(carparkSeq).getIdentifier());
            event.setLicencePlate(car.getlicencePlate());
            event.setArrivalTime(car.getArrivalTime());
            eventSender.sendInsertEvent(event);
        }
        // check for the selected carpark whether any cars should leave
        // TODO: ideally this should be checked for all carparks, not just for number carparkSeq
        
        long now = new Date().getTime();
        if (parkedCars.get(carparkSeq).first().getTimeToLeave() < now) {
            // find all parkedCars that should leave by  now
            Iterator<ParkedCar> itr = new TreeSet(parkedCars.get(carparkSeq)).iterator(); //create clone in order to be able to remove elements from original parkedCars treeset
            while (itr.hasNext()) {
                ParkedCar parkedCar = itr.next();
                if (parkedCar.getTimeToLeave() > now) {
                    // as soon as we find a car that does not yet have to leave, we can stop processing the parked cars:
                    // because they are ordered on time to leave, all subsequent cars will not yet have to leave
                    break;
                }
                CarMovementEvent exitEvent = new CarMovementEvent();
                exitEvent.setEntryOrExit(-1);
                exitEvent.setLicencePlate(parkedCar.getlicencePlate());
                exitEvent.setCarparkIdentifier(parkedCar.getCarparkIdentifier());
                eventSender.sendInsertEvent(exitEvent);
                parkedCars.get(carparkSeq).remove(parkedCar);

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
        long timeToLeave;
        long arrivalTime;
        private String carparkIdentifier;

        public void setCarparkIdentifier(String carparkIdentifier) {
            this.carparkIdentifier = carparkIdentifier;
        }

        public String getCarparkIdentifier() {
            return carparkIdentifier;
        }

        public ParkedCar() {

            this.licencePlate = randChar() + randChar() + "-" + randInt(1, 999) + "-" + randChar() + randChar();
            // currently the staying time for a car is maximum 150 seconds
            this.timeToLeave = new Date().getTime() + 5000 * randInt(1, 30);
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
            return new Character((char) randInt(65, 90)).toString();
        }
    }

    private class ParkedCarLeaveTimeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            // TODO Implement this method
            return Long.compare(((ParkedCar) o1).getTimeToLeave(), ((ParkedCar) o2).getTimeToLeave());
        }
    }
}
