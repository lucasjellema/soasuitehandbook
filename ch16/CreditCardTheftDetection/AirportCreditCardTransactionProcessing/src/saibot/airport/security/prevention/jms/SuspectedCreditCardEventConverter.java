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

public class SuspectedCreditCardEventConverter  //implements OutboundMessageConverter 
                                            {
    public SuspectedCreditCardEventConverter() {
        super();
    }
    
    public List<Message> convert(Session session, Object inputEvent) 
           throws 
    // MessageConverterException, 
     JMSException 
    {
            SuspectCreditCardEvent event = (SuspectCreditCardEvent) inputEvent;
            MapMessage message = session.createMapMessage();
            message.setString("CreditCardNumber", event.getCreditCardNumber());
            message.setFloat("SumAmounts", event.getSumAmounts());
            message.setFloat("ShoppingDuration", event.getShoppingDuration());
            
            List<Message> messages = new ArrayList<Message>();
            messages.add(message);
            return messages;
        }
}
