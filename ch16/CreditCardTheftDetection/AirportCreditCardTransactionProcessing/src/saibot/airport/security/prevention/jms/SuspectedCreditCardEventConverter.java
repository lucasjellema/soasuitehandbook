package saibot.airport.security.prevention.jms;

import com.bea.wlevs.adapters.jms.api.MessageConverterException;
import com.bea.wlevs.adapters.jms.api.OutboundMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import java.util.ArrayList;
import java.util.List;

import javax.jms.MapMessage;

import saibot.airport.security.prevention.event.SuspectCreditCardEvent;

public class SuspectedCreditCardEventConverter implements OutboundMessageConverter {
    public SuspectedCreditCardEventConverter() {
        super();
    }

    public List<Message> convert(Session session, Object inputEvent) throws MessageConverterException, JMSException {
        SuspectCreditCardEvent event = (SuspectCreditCardEvent) inputEvent;
        MapMessage message = session.createMapMessage();
        message.setString("creditCardNumber", event.getCreditCardNumber());
        message.setString("listOfShops", intListCSV(event.getShops()));
        message.setString("listOfAmounts", floatListCSV(event.getPurchaseAmounts()));
        message.setFloat("totalSum", event.getSumAmounts());
        message.setFloat("durationOfShoppingSpree", event.getShoppingDuration());
        

        List<Message> messages = new ArrayList<Message>();
        messages.add(message);
        return messages;
    }
    
    public String intListCSV(List<Integer> intList) {
        String intsString = "";
        for (Integer intId:intList) {
            intsString = intsString+","+intId;
        }
        // remove initial comma
        return intsString.substring(1);
    }
    public String floatListCSV(List<Float> floatList) {
        String floatsString = "";
        for (Float floatId:floatList) {
            floatsString = floatsString+","+floatId;
        }
        // remove initial comma
        return floatsString.substring(1);
    }
}
