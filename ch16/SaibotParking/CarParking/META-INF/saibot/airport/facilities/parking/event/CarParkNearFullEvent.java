package saibot.airport.facilities.parking.event;

public class CarParkNearFullEvent {
    private String carparkIdentifier;
    private Integer carCount;
    private Integer capacity;
    private Float percentageFull;
    private Float lowestRecentCount;
private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCarparkIdentifier(String carparkIdentifier) {
        this.carparkIdentifier = carparkIdentifier;
    }

    public String getCarparkIdentifier() {
        return carparkIdentifier;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setPercentageFull(Float percentageFull) {
        this.percentageFull = percentageFull;
    }

    public Float getPercentageFull() {
        return percentageFull;
    }

    public void setLowestRecentCount(Float lowestRecentCount) {
        this.lowestRecentCount = lowestRecentCount;
    }

    public Float getLowestRecentCount() {
        return lowestRecentCount;
    }


    public CarParkNearFullEvent() {
        super();
    }
}
