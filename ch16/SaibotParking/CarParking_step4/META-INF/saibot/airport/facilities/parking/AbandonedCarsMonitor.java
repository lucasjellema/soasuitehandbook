package saibot.airport.facilities.parking;

import com.bea.wlevs.ede.api.StreamSink;

import saibot.airport.facilities.parking.event.AbandonedCarEvent;

public class AbandonedCarsMonitor
    implements StreamSink {
       

        public void onInsertEvent(Object event) {
            if (event instanceof AbandonedCarEvent) {
                AbandonedCarEvent ace = (AbandonedCarEvent)event;
                System.out.println("!!!!!!!Abandoned Car identified in in Car Park "+ace.getCarparkIdentifier()+" : licence plate "+ace.getLicencePlate()
                                   + " - parked since " +ace.getArrivalDate().toString());
            }
        }
}
