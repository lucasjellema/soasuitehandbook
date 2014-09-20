package saibot.airport.security.monitor.view;

public class CreditCardPurchase {
    
    private Integer shopIdentifier;
    private Float amount;
    private Integer sequence;
    private Integer transactionSeq;

    public void setTransactionSeq(Integer transactionSeq) {
        this.transactionSeq = transactionSeq;
    }

    public Integer getTransactionSeq() {
        return transactionSeq;
    }

    public void setShopIdentifier(Integer shopIdentifier) {
        this.shopIdentifier = shopIdentifier;
    }

    public Integer getShopIdentifier() {
        return shopIdentifier;
    }

    public CreditCardPurchase(String shopIdentifier, String amount, Integer sequence, String creditCardNumber, Integer transactionSeq) {
        super();
        this.shopIdentifier = Integer.parseInt(shopIdentifier);
        this.amount = Float.parseFloat(amount);
        this.sequence = sequence;
        this.creditCardNumber = creditCardNumber;
        this.transactionSeq = transactionSeq;
    }

    public CreditCardPurchase(Integer shopIdentifier, Float amount, Integer sequence, String creditCardNumber) {
        super();
        this.shopIdentifier = shopIdentifier;
        this.amount = amount;
        this.sequence = sequence;
        this.creditCardNumber = creditCardNumber;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    private String creditCardNumber;
    
    
    public CreditCardPurchase() {
        super();
    }
}
