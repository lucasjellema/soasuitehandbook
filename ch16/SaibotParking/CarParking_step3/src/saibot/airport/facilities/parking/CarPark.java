package saibot.airport.facilities.parking;

public class CarPark {
    
    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
    private String name;
     private Integer capacity;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public CarPark(String identifier,String name, Integer capacity) {
        super();
        this.identifier= identifier;
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public CarPark() {
        super();
    }
}
