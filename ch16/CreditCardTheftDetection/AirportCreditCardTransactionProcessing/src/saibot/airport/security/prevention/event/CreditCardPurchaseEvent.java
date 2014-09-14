package saibot.airport.security.prevention.event;

public class CreditCardPurchaseEvent {
    
    private Float amount;
    private String creditCardNumber;
    private Integer shopIdentifier;

    public CreditCardPurchaseEvent(Float amount, String creditCardNumber, Integer shopIdentifier) {
        super();
        this.amount = amount;
        this.creditCardNumber = creditCardNumber;
        this.shopIdentifier = shopIdentifier;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setShopIdentifier(Integer shopIdentifier) {
        this.shopIdentifier = shopIdentifier;
    }

    public Integer getShopIdentifier() {
        return shopIdentifier;
    }

    public CreditCardPurchaseEvent() {
        super();
    }
}
