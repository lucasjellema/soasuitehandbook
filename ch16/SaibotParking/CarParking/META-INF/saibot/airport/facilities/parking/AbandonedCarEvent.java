package saibot.airport.facilities.parking;

import java.util.Date;

public class AbandonedCarEvent {
    
    private String licencePlate;
    private Integer carparkIdentifier;
    private Date arrivalDate;

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

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
    
    public AbandonedCarEvent() {
        super();
    }
}
