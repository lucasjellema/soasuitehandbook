package saibot.airport.services.spring;

public class FlightDetailProvider {
    private ValueMapper airlineMapper;
    private ValueMapper flightActionMapper;


    public void setAirlineMapper(ValueMapper airlineMapper) {
        this.airlineMapper = airlineMapper;
    }

    public void setFlightActionMapper(ValueMapper flightActionMapper) {
        this.flightActionMapper = flightActionMapper;
    }


    
    public String getCarrierAnnouncementName( String carrier) {
        return airlineMapper.mapValue("carrier", carrier);
    }
    
    public String getActionAnnouncementTerm( String action) {
        return flightActionMapper.mapValue("flightStatus", action);
    }
}
