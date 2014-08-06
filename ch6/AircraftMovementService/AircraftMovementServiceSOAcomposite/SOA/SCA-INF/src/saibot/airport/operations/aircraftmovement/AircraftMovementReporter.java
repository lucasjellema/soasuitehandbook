package saibot.airport.operations.aircraftmovement;

import java.util.Date;

public interface AircraftMovementReporter {

    public void reportAircraftActivity(Date movementTimestamp, Integer flightnumber, String carrierIataCode,
                                       String airportIataCode, String arrivalOrDeparture,
                                       String aircraftIataEquipmentCode, Integer numberOfPassengers);
}
