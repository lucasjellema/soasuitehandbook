package saibot.airport.facilities.parking.event;

public class CarStayDoneEvent {
    private String carparkIdentifier;
    private String licencePlate;
    private Long carstayDuration;
    private Long arrivalTime;

    public void setCarparkIdentifier(String carparkIdentifier) {
        this.carparkIdentifier = carparkIdentifier;
    }

    public String getCarparkIdentifier() {
        return carparkIdentifier;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setCarstayDuration(Long carstayDuration) {
        this.carstayDuration = carstayDuration;
    }

    public Long getCarstayDuration() {
        return carstayDuration;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public CarStayDoneEvent() {
        super();
    }
}
