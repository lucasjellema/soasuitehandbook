package saibot.airport.security.prevention.event;

import java.util.List;

public class CreditCardPurchasesSummaryEvent {
    
    private Double sumAmounts;
    private Long numberOfPurchases;
    private Integer numberOfCreditCards;

    public void setNumberOfCreditCards(Integer numberOfCreditCards) {
        this.numberOfCreditCards = numberOfCreditCards;
    }

    public Integer getNumberOfCreditCards() {
        return numberOfCreditCards;
    }

    public void setSumAmounts(Double sumAmounts) {
        this.sumAmounts = sumAmounts;
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

    public void setShops(List<Integer> shops) {
        this.shops = shops;
    }

    public List<Integer> getShops() {
        return shops;
    }
    private List<Integer> shops;
    
    
    public CreditCardPurchasesSummaryEvent() {
        super();
    }
}
