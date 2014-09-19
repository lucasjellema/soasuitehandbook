package saibot.airport.facilities.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarParkManager {
    
   
    private static         Map<String, Object> carparks;
    
    public CarParkManager() {
        super();
        carparks = new CarParkCacheLoader().loadAll();
    }
    
    public static List<String> getCarparkDetails(String carparkIdentifier)
    {
      List<String> carparkDetails = new ArrayList<String>();  
      // Map<String, List<String>> directory = ... 
      carparkDetails.add(((CarPark)carparks.get(carparkIdentifier)).getName());
      return carparkDetails;
    }
}
