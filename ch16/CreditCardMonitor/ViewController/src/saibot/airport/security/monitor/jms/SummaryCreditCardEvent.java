package saibot.airport.security.monitor.jms;

import java.util.Date;

public class SummaryCreditCardEvent {
    private Double sumAmounts;
    private Long numberOfPurchases;
    private Integer numberOfCreditCards;
    private Date timestamp;
    Integer numberOfShops ;

    public void setSumAmounts(Double sumAmounts) {
        this.sumAmounts = sumAmounts;
    }

    public SummaryCreditCardEvent(Double sumAmounts, Long numberOfPurchases, Integer numberOfCreditCards,
                                  Integer numberOfShops) {
        super();
        this.sumAmounts = sumAmounts;
        this.numberOfPurchases = numberOfPurchases;
        this.numberOfCreditCards = numberOfCreditCards;
        this.numberOfShops = numberOfShops;
        this.timestamp = new Date();
    }

    public Double getSumAmounts() {
        return sumAmounts;
    }

    public void setNumberOfPurchases(Long numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public Long getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfCreditCards(Integer numberOfCreditCards) {
        this.numberOfCreditCards = numberOfCreditCards;
    }

    public Integer getNumberOfCreditCards() {
        return numberOfCreditCards;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setNumberOfShops(Integer numberOfShops) {
        this.numberOfShops = numberOfShops;
    }

    public Integer getNumberOfShops() {
        return numberOfShops;
    }

    public SummaryCreditCardEvent() {
        super();
    }
}
