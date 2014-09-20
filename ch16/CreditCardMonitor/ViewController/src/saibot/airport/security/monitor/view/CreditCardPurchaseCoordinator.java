package saibot.airport.security.monitor.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

import saibot.airport.security.monitor.jms.SummaryCreditCardEvent;
import saibot.airport.security.monitor.jms.SuspiciousCreditCardEvent;
import saibot.airport.security.monitor.jms.SuspiciousCreditCardEventHandler;
import saibot.airport.security.monitor.jms.CreditCardQueueListener;
import saibot.airport.security.monitor.jms.SummaryCreditCardEventHandler;

public class CreditCardPurchaseCoordinator implements SuspiciousCreditCardEventHandler, SummaryCreditCardEventHandler {
    private List<CreditCardPurchase> creditCardPurchases = new ArrayList<CreditCardPurchase>();
    private static ADFLogger _logger = ADFLogger.createADFLogger(CreditCardPurchaseCoordinator.class);
    private Integer transactionCounter = 0;
    private List<SummaryCreditCardEvent> snapshots = new ArrayList<SummaryCreditCardEvent>();

    public void setSnapshots(List<SummaryCreditCardEvent> snapshots) {
        this.snapshots = snapshots;
    }

    public List<SummaryCreditCardEvent> getSnapshots() {
        return snapshots;
    }

    private CreditCardQueueListener ccql;

    public void setCcql(CreditCardQueueListener ccql) {
        this.ccql = ccql;
        _logger.severe("CCQL is injected");
    }

    public CreditCardQueueListener getCcql() {
        return ccql;
    }
    private Double totalAmount = 0.0d;
    private Long totalNumberOfTransactions = 0L;
    private Integer numberOfDistinctCreditCards = 0;
    private Integer numberOfShopsInvolved = 0;

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        if (getSnapshots().size()>0) {
        return getSnapshots().get((getSnapshots().size())-1).getSumAmounts();
        }
        else return 0d;
    }

    public void setTotalNumberOfTransactions(Long totalNumberOfTransactions) {
        this.totalNumberOfTransactions = totalNumberOfTransactions;
    }

    public Long getTotalNumberOfTransactions() {
        if (getSnapshots().size()>0) {
        return getSnapshots().get((getSnapshots().size())-1).getNumberOfPurchases();
        }
        else return 0L+getSnapshots().size();
    }

    public void setNumberOfDistinctCreditCards(Integer numberOfDistinctCreditCards) {
        this.numberOfDistinctCreditCards = numberOfDistinctCreditCards;
    }

    public Integer getNumberOfDistinctCreditCards() {
        if (getSnapshots().size()>0) {
        return getSnapshots().get((getSnapshots().size())-1).getNumberOfCreditCards();
        }
        else return 0;
        //return numberOfDistinctCreditCards;
    }

    public void setNumberOfShopsInvolved(Integer numberOfShopsInvolved) {
        this.numberOfShopsInvolved = numberOfShopsInvolved;
    }

    public Integer getNumberOfShopsInvolved() {
        if (getSnapshots().size()>0) {
        return getSnapshots().get((getSnapshots().size())-1).getNumberOfShops();
        }
        else return 0;
    }


    public void setCreditCardPurchases(List<CreditCardPurchase> creditCardPurchases) {
        this.creditCardPurchases = creditCardPurchases;
    }

    public List<CreditCardPurchase> getCreditCardPurchases() {
        return creditCardPurchases;
    }

    public CreditCardPurchaseCoordinator() {
        super();
        CreditCardQueueListener.getEventHandlers().add(this);
        CreditCardQueueListener.getSummaryEventHandlers().add(this);
    }

    @Override
    public void handleEvent(SuspiciousCreditCardEvent event) {
        transactionCounter++;
        _logger.severe("received event from listener; new transaction: " + transactionCounter + "size of shop array :" +
                       event.getShops().size() + " #purchases until now :" + creditCardPurchases.size());

        for (int index = 0; index < event.getShops().size(); index++) {
            _logger.severe("add purchase amount " + index + " from event " + event.getPurchaseAmounts().get(index) +
                           " transaction " + transactionCounter);
            creditCardPurchases.add(new CreditCardPurchase(event.getShops().get(index),
                                                           event.getPurchaseAmounts().get(index), index + 1,
                                                           event.getCreditCardNumber(), transactionCounter));

        }
        _logger.severe("Total number of purchases after processing: " + transactionCounter + "= :" +
                       creditCardPurchases.size());
    }


    public void resetMap(ActionEvent actionEvent) {
        transactionCounter = 0;
        creditCardPurchases = new ArrayList<CreditCardPurchase>();

    }

    @Override
    public void handleEvent(SummaryCreditCardEvent event) {
        // TODO Implement this method
        _logger.severe("*** received summary event from listener; total sum " + event.getSumAmounts() + " shops " +
                       event.getNumberOfShops());
        this.setNumberOfDistinctCreditCards(event.getNumberOfCreditCards());
        this.setTotalAmount(event.getSumAmounts());
        this.setNumberOfShopsInvolved(event.getNumberOfShops());
//        this.setNumberOfShopsInvolved(85);
        this.setTotalNumberOfTransactions(event.getNumberOfPurchases());
        _logger.severe("*** Updated suymmary from event ; total sum " + this.getTotalAmount() + " shops " +
                       this.getNumberOfShopsInvolved());
this.getSnapshots().add(event);
    }
}
