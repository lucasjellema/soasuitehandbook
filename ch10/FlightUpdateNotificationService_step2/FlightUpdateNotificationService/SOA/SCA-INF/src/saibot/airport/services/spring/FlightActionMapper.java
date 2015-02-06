package saibot.airport.services.spring;

public class FlightActionMapper implements ValueMapper {
    @Override
    public String mapValue(String domain, String sourceValue) {
        String mappedValue = "";
        switch (sourceValue) {
        case "FinalApproach":
            mappedValue = " almost at our airport. It is in its final approach and ready for touch down shortly. ";
            break;
        case "GateOpen":
            mappedValue = " open for boarding at the gate. ";
            break;
        case "GateClosing":
            mappedValue = " currently closing its door. Final passengers have to come to the gate immediately. ";
            break;
        case "Prepare":
            mappedValue = " almost ready to start boarding at its designated gate. ";
            break;
        case "BagageOnBelt":
            mappedValue =
                " complete, passengers are leaving the aircraft and the bagage is available on the conveyor belt. ";
            break;
        case "AtGate":
            mappedValue = " safely arrived at the gate where off loading will commence shortly. ";
            break;

        default:
            mappedValue = sourceValue;
        }
        return mappedValue;
    }
}
