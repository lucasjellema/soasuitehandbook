package saibot.airport.events.client;

import java.util.Properties;

import javax.naming.Context;

import javax.xml.namespace.QName;

import oracle.fabric.blocks.event.EdnConnection;

import oracle.integration.platform.blocks.event.BusinessEventBuilder;
import oracle.integration.platform.blocks.event.BusinessEventConnectionFactorySupport;

import oracle.soa.common.util.XMLUtil;

import org.w3c.dom.Element;

public class FlightStatusUpdateEventPublisher {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(Context.PROVIDER_URL, "t3://soa2admin2:8001/soa-infra");
        props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.SECURITY_PRINCIPAL, "weblogic");
        props.put(Context.SECURITY_CREDENTIALS, "weblogic1");

        String FlightStatusUpdateEventBody =
            "<FlightStatusUpdate xmlns=\"saibot.airport/events/flight\">\n" + "  <Carrier>ZQ</Carrier>\n" +
            "  <FlightNumber>1134</FlightNumber>\n" + "  <FlightStatus>\n" +
            "    <Action xmlns=\"saibot.airport/data/flight\">GateOpen</Action>\n" +
            "  </FlightStatus>\n" + "</FlightStatusUpdate>";
        Element eventBody = null;
        try {
            eventBody = XMLUtil.parseDocumentFromXMLString(FlightStatusUpdateEventBody.toString()).getDocumentElement();
            BusinessEventConnectionFactorySupport.setJndiProperties(props);
            EdnConnection ec = (EdnConnection) BusinessEventConnectionFactorySupport.findRelevantBusinessEventConnectionFactory(true).createBusinessEventConnection();
            String namespace = "saibot.airport/events/flight";
            String eventName = "FlightStatusUpdateEvent";
            // Create an event
            BusinessEventBuilder builder = BusinessEventBuilder.newInstance();
            builder.setEventName(new QName(namespace, eventName));
            builder.setBody(eventBody);
            // publish
            ec.publishEvent(builder.createEvent(), 4);
            ec.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
