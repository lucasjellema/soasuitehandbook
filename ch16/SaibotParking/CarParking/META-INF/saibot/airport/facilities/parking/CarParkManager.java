package saibot.airport.facilities.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParkManager {
    
    private static String[] carparkNames = new String[]{"VIP Parking Lot", "Traveller Parking Area I", "Traveller Parking Area II", "Short Stay Parking Lot", "Rather not stay parking area" };
    
    public CarParkManager() {
        super();
    }
    
    public static List<String> getCarparkDetails(Integer carparkIdentifier)
    {
      List<String> carparkDetails = new ArrayList<String>();  
      // Map<String, List<String>> directory = ... 
      carparkDetails.add(carparkNames[carparkIdentifier]);
      return carparkDetails;
    }
}
