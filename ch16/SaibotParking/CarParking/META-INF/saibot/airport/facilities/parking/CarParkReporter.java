package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.StreamSink;

import saibot.airport.facilities.parking.event.CarParkEvent;
import saibot.airport.facilities.parking.event.CarParkNearFullEvent;

public class CarParkReporter implements StreamSink {
    public CarParkReporter() {
        super();
    }

    public void onInsertEvent(Object event) {
        if (event instanceof CarParkEvent) {
            CarParkEvent cpe = (CarParkEvent)event;
            System.out.println("Current number of cars parked in Car Park "+cpe.getCarparkIdentifier()+" : "+cpe.getCarCount()
                               + " - " +cpe.getDescription()+" percentage full "+(cpe.getPercentageFull())+"%");
        }
        if (event instanceof CarParkNearFullEvent) {
            CarParkNearFullEvent cpe = (CarParkNearFullEvent)event;
            System.out.println("******* Carpark "+ cpe.getDescription()+" is close to filling up. Number of cars parked : "+cpe.getCarCount()
                               + " (Capacity = "+cpe.getCapacity()+", current percentage full: " +(cpe.getPercentageFull())+"% ; the lowest carcount recently was "+cpe.getLowestRecentCount()+" )");
            }
    }
}
