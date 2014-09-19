package saibot.airport.facilities.parking.jms;

import java.util.ArrayList;
import java.util.List;
import com.bea.wlevs.adapters.jms.api.MessageConverterException;
import com.bea.wlevs.adapters.jms.api.OutboundMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import java.util.ArrayList;
import java.util.List;

import javax.jms.MapMessage;

import saibot.airport.facilities.parking.event.CarParkNearFullEvent;

public class CarParkNearlyFullEventConverter implements OutboundMessageConverter {
   

    public List<Message> convert(Session session, Object inputEvent) throws MessageConverterException, JMSException {
        CarParkNearFullEvent event = (CarParkNearFullEvent) inputEvent;
        MapMessage message = session.createMapMessage();
        message.setString("carparkIdentifier", event.getCarparkIdentifier());
        message.setFloat("percentageFull", event.getPercentageFull());
        message.setInt("capacity", event.getCapacity());
        message.setString("description", event.getDescription());
        message.setInt("currentCarCount", event.getCarCount());
        message.setFloat("lowestRecentCount", event.getLowestRecentCount());       
        message.setFloat("percentageFull", event.getPercentageFull());
        
System.out.println("Convcerter did it");
        List<Message> messages = new ArrayList<Message>();
        messages.add(message);
        return messages;
    }
}
