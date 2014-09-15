package saibot.airport.security.prevention;

import com.bea.wlevs.ede.api.StreamSink;

import java.util.Date;

import saibot.airport.security.prevention.event.CreditCardPurchaseEvent;
import saibot.airport.security.prevention.event.CreditCardPurchasesSummaryEvent;
import saibot.airport.security.prevention.event.SuspectCreditCardEvent;

public class CreditCardReporter implements StreamSink {

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSink#onInsertEvent(java.lang.Object)
     */
    public void onInsertEvent(Object event) {
        System.out.println("CreditCard Event "+event);
        if (event instanceof SuspectCreditCardEvent) {
            SuspectCreditCardEvent ccpe = (SuspectCreditCardEvent)event;
            System.out.println("!!!! Very Suspect Credit Card Purchases with card  "+ccpe.getCreditCardNumber());
            System.out.println("  - in the last "+ ((Double)(ccpe.getShoppingDuration()* 1E-09)).longValue()+" seconds; ");
            System.out.println("  - total sum of purchases : $"+ccpe.getSumAmounts()+" in the following shops (in this order) "+ccpe.getShops());
            System.out.println("  - List of purchase amounts : "+ccpe.getPurchaseAmounts());

        }
        if (event instanceof CreditCardPurchaseEvent) {
            CreditCardPurchaseEvent ccpe = (CreditCardPurchaseEvent)event;
            System.out.println("Credit Card Purchase "+ccpe.getCreditCardNumber()+" : $"+ccpe.getAmount() );
        }
        if (event instanceof CreditCardPurchasesSummaryEvent) {
            CreditCardPurchasesSummaryEvent ccpse = (CreditCardPurchasesSummaryEvent)event;
            if (ccpse.getNumberOfPurchases()>0) {
                System.out.println("Credit Card Purchases Summary Update ");
                System.out.println("------------------------------------");
                System.out.println(" * Total Number of Purchases "+ ccpse.getNumberOfPurchases());
                System.out.println("  . in a total of "+(ccpse.getShops()!=null?ccpse.getShops().size():0)+" shops");
                System.out.println("  . with " +ccpse.getNumberOfCreditCards()+" different credit cards."   );
                System.out.println(" * Total Amount for all purchases combined: $"+ ccpse.getSumAmounts().longValue() );        
            }
        }
        
//        CredidCard Event eventType=SuspectedCreditCardEvent object=SuspectedCreditCardEvent kind=null time=0 properties={id=38d36838-c0a8-469a-8a29-83f4c9018daa, priority=5}, javaContent=null, xmlContent=<SuspectCreditCardEvent xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="saibot.airport/security ../Schemas/SecurityEvents.xsd" xmlns="saibot.airport/security">
//          <SumAmounts>1345</SumAmounts>
//          <CreditCardNumber>6473-9121-7181-9181</CreditCardNumber>
//          <ShoppingDuration>591</ShoppingDuration>
//          <Purchases>
//            <Amount>250</Amount>
//            <ShopIdentifier>23</ShopIdentifier>
//          </Purchases>
//          <Purchases>
//            <Amount>290</Amount>
//            <ShopIdentifier>26</ShopIdentifier>
//          </Purchases>
//          <Purchases>
//            <Amount>210</Amount>
//            <ShopIdentifier>25</ShopIdentifier>
//          </Purchases>
//          <Purchases>
//            <Amount>460</Amount>
//            <ShopIdentifier>32</ShopIdentifier>
//          </Purchases>
//        </SuspectCreditCardEvent>
//         isTotalOrderGuarantee=false

    }
    
    public CreditCardReporter() {
        super();
    }
}
