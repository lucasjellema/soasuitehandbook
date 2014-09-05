package saibot.airport.facilities.parking;

import java.util.Date;

public class CarMovementEvent {
    
    private Integer carparkIdentifier;
    private Integer entryOrExit;
    private String licencePlate;
    private Long arrivalTime;


    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setCarparkIdentifier(Integer carparkIdentifier) {
        this.carparkIdentifier = carparkIdentifier;
    }

    public Integer getCarparkIdentifier() {
        return carparkIdentifier;
    }

    public void setEntryOrExit(Integer entryOrExit) {
        this.entryOrExit = entryOrExit;
    }

    public Integer getEntryOrExit() {
        return entryOrExit;
    }

    public CarMovementEvent() {
        super();
    }
}
