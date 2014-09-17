package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.StreamSink;

import saibot.airport.facilities.parking.event.CarParkEvent;
import saibot.airport.facilities.parking.event.CarStayDoneEvent;

public class CarParkReporter implements StreamSink {
    public CarParkReporter() {
        super();
    }

    public void onInsertEvent(Object event) {
        if (event instanceof CarParkEvent) {
            CarParkEvent cpe = (CarParkEvent)event;
            if (cpe.getCarCount()<0) {
            System.out.println("Car Park "+cpe.getCarparkIdentifier()+" The average stay of cars is "+0.1*(Math.round(1E-8*cpe.getAverageStayDuration()))+" seconds." );
            }
            if (cpe.getAverageStayDuration()<0) {
              System.out.println("Current number of cars parked in Car Park "+cpe.getCarparkIdentifier()+" ("+cpe.getDescription()+") : "+cpe.getCarCount()
            );
            }
        }
        if (event instanceof CarStayDoneEvent) {
            CarStayDoneEvent cpe = (CarStayDoneEvent)event;
            System.out.println("++ Car with licence plate "+cpe.getLicencePlate()
                               +" leaves carpark "+ cpe.getCarparkIdentifier()
                               +" after a stay of "+Math.round(cpe.getCarstayDuration()*1E-9)+" seconds.");
            }
    }
}
