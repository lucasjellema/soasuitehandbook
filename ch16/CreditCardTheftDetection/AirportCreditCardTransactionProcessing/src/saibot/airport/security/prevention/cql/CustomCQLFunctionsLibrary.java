package saibot.airport.security.prevention.cql;

import java.util.List;

public class CustomCQLFunctionsLibrary {
    public CustomCQLFunctionsLibrary() {
        super();
    }

    public String purchasesList(List shops, List amounts) {
        String purchases = "<PurchasesList>";
        for (int i = 0; i < shops.size(); i++) {
            purchases =
                purchases + "<Purchase>\n" + "    <Amount>" + amounts.get(i) + "</Amount>\n" + "    <ShopIdentifier>" +
                shops.get(i) + "</ShopIdentifier>\n" + "  </Purchase>";
        }
        purchases = purchases + "</PurchasesList>";
        return purchases;
    }
}
