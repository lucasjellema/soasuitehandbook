package saibot.airport.services.spring;

public class FlightAnnouncementComposer implements Announcer {
    
    private FlightDetailProvider flightDetailProvider;

    public void setFlightDetailProvider(FlightDetailProvider flightDetailProvider) {
        this.flightDetailProvider = flightDetailProvider;
    }


    @Override
    public String composeFlightStatusAnnouncement(Flight flight) {
        String airline = flightDetailProvider.getCarrierAnnouncementName(flight.getCarrier());
        String action = flightDetailProvider.getActionAnnouncementTerm(flight.getAction());
        // TODO Implement this method
        return "Announcement about flight "+flight.getCarrier()+" "+getSeparateNumbers(flight.getFlightNumber())+" operated by "+airline+" status is "+action;
    }

    private String getSeparateNumbers(String flightNumber) {
        String spelledOutFlightNumber ="";
        for (int i=0;i< flightNumber.length(); i++) {
            spelledOutFlightNumber = spelledOutFlightNumber+ flightNumber.substring(i,i+1) + " " ;
        }
        return spelledOutFlightNumber;
    }
}
