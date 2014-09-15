package saibot.airport.security.prevention.event;

import java.util.List;

public class SuspectCreditCardJMSEvent {
    
    private Float totalSum;
    private Float durationOfShoppingSpree;
    private String creditCardNumber;
    private String listOfShops;
    private String listOfAmounts;
    
    
    public SuspectCreditCardJMSEvent() {
        super();
    }

    public void setTotalSum(Float totalSum) {
        this.totalSum = totalSum;
    }

    public Float getTotalSum() {
        return totalSum;
    }

    public void setDurationOfShoppingSpree(Float durationOfShoppingSpree) {
        this.durationOfShoppingSpree = durationOfShoppingSpree;
    }

    public Float getDurationOfShoppingSpree() {
        return durationOfShoppingSpree;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setListOfShops(String listOfShops) {
        this.listOfShops = listOfShops;
    }

    public String getListOfShops() {
        return listOfShops;
    }

    public void setListOfAmounts(String listOfAmounts) {
        this.listOfAmounts = listOfAmounts;
    }

    public String getListOfAmounts() {
        return listOfAmounts;
    }
}
