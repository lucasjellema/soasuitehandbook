package saibot.airport.security.monitor.jms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuspiciousCreditCardEvent {
    
    private String creditCardNumber;
    private Float sumAmounts;

    public void setSumAmounts(Float sumAmounts) {
        this.sumAmounts = sumAmounts;
    }

    public Float getSumAmounts() {
        return sumAmounts;
    }

    public void setShops(List<String> shops) {
        this.shops = shops;
    }

    public List<String> getShops() {
        return shops;
    }

    public void setPurchaseAmounts(List<String> purchaseAmounts) {
        this.purchaseAmounts = purchaseAmounts;
    }

    public List<String> getPurchaseAmounts() {
        return purchaseAmounts;
    }
    private List<String> shops;
    private List<String> purchaseAmounts;

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public SuspiciousCreditCardEvent(String creditCardNumber, Float sumAmounts, String shopsCSV, String purchaseAmountsCSV) {
        super();
        this.creditCardNumber = creditCardNumber;
        this.sumAmounts = sumAmounts;
        this.shops = Arrays.asList(shopsCSV.split(","));
        this.purchaseAmounts = Arrays.asList(purchaseAmountsCSV.split(","));
    }
}
