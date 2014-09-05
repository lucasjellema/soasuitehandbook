package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.StreamSink;

public class CarParkReporter implements StreamSink {
    public CarParkReporter() {
        super();
    }

    public void onInsertEvent(Object event) {
        if (event instanceof CarParkEvent) {
            CarParkEvent cpe = (CarParkEvent)event;
//            System.out.println("Current number of cars parked in Car Park "+cpe.getCarparkIdentifier()+" : "+cpe.getCarCount()
//                               + " - " +cpe.getDescription());
        }
    }
}
