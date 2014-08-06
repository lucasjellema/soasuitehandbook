package saibot.airport.finance;

import javax.ejb.Remote;

@Remote
public interface FinanceAircraftMovementReporter {
    
    public void reportAircraftMovement( AircraftMovement aircraftMovement);
}
