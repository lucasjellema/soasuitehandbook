package saibot.airport.facilities.parking;

public class CarParkEvent {
    
    private Integer carparkIdentifier;
    private Integer carCount;
    private String  description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCarparkIdentifier(Integer carparkIdentifier) {
        this.carparkIdentifier = carparkIdentifier;
    }

    public Integer getCarparkIdentifier() {
        return carparkIdentifier;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public Integer getCarCount() {
        return carCount;
    }


    public CarParkEvent() {
        super();
    }
}
