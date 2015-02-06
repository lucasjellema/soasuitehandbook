package saibot.airport.services.spring;

import java.util.Date;

public class Flight {
    
    String carrier;
    Date   timestamp;
    String flightNumber;
    String status;
    String action;
    String gate;
    String pier;
    String terminal;

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getGate() {
        return gate;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public String getPier() {
        return pier;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTerminal() {
        return terminal;
    }
}
