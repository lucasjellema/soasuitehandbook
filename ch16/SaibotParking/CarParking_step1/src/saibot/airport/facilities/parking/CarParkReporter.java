package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.StreamSink;

import saibot.airport.facilities.parking.event.CarMovementEvent;
import saibot.airport.facilities.parking.event.CarParkEvent;

public class CarParkReporter implements StreamSink {
    public void onInsertEvent(Object event) {
        if (event instanceof CarParkEvent) {
            CarParkEvent cpe = (CarParkEvent)event;
            System.out.println("Current number of cars parked in Car Park "+cpe.getCarparkIdentifier()+" : "+cpe.getCarCount()
                               //+" percentage full "+(cpe.getPercentageFull())+"%"
                               //+" The average stay of cars is "+(0.1*Math.round(1E-08*cpe.getAverageStayDuration()))+" seconds." 
                               );
        }
        if (event instanceof CarMovementEvent) {
            CarMovementEvent cpe = (CarMovementEvent)event;
            System.out.println("Car with licence plate "+cpe.getLicencePlate()
                               +" just "+ ( cpe.getEntryOrExit()==1?"arrived at":"left from") +" car park "+cpe.getCarparkIdentifier() );
        }
    }
}
