package saibot.airport.security.prevention.event;

import java.util.List;

public class SuspectCreditCardEvent {
    
    private Float sumAmounts;
    private String creditCardNumber;
    private List<Integer> shops;
    private List<Float> purchaseAmounts;

    public void setPurchaseAmounts(List<Float> purchaseAmounts) {
        this.purchaseAmounts = purchaseAmounts;
    }

    public List<Float> getPurchaseAmounts() {
        return purchaseAmounts;
    }
    private Long shoppingDuration;

    public void setShoppingDuration(Long shoppingDuration) {
        this.shoppingDuration = shoppingDuration;
    }

    public Long getShoppingDuration() {
        return shoppingDuration;
    }


    public void setShops(List shops) {
        this.shops = shops;
    }

    public List getShops() {
        return shops;
    }


    public void setSumAmounts(Float sumAmounts) {
        this.sumAmounts = sumAmounts;
    }

    public Float getSumAmounts() {
        return sumAmounts;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }


    public SuspectCreditCardEvent() {
        super();
    }
}
