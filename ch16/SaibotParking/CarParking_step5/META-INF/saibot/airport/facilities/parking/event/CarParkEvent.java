package saibot.airport.facilities.parking.event;

public class CarParkEvent {
    
    private String carparkIdentifier;
    private Integer carCount;
    private Float percentageFull;
    private Long averageStayDuration;

    public void setAverageStayDuration(Long averageStayDuration) {
        this.averageStayDuration = averageStayDuration;
    }

    public Long getAverageStayDuration() {
        return averageStayDuration;
    }

    public void setPercentageFull(Float percentageFull) {
        this.percentageFull = percentageFull;
    }

    public Float getPercentageFull() {
        return percentageFull;
    }
    private String  description;

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


    public CarParkEvent() {
        super();
    }
}
