package saibot.airport.events.client;

import java.util.Properties;

import javax.naming.Context;

import javax.xml.namespace.QName;

import oracle.fabric.blocks.event.BusinessEventConnection;
import oracle.fabric.blocks.event.BusinessEventConnectionFactory;
import oracle.fabric.blocks.event.BusinessEventHandler;
import oracle.fabric.blocks.event.EdnConnection;
import oracle.fabric.common.BusinessEvent;
import oracle.fabric.common.FabricInvocationException;

import oracle.integration.platform.blocks.event.BusinessEventConnectionFactorySupport;

public class FlightStatusUpdateEventSubscriber implements BusinessEventHandler {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(Context.PROVIDER_URL, "t3://soa2admin2:8001/soa-infra");
        props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.SECURITY_PRINCIPAL, "weblogic");
        props.put(Context.SECURITY_CREDENTIALS, "weblogic1");

        BusinessEventConnectionFactorySupport.setJndiProperties(props);
        EdnConnection ec =
            (EdnConnection) BusinessEventConnectionFactorySupport.findRelevantBusinessEventConnectionFactory(true).createBusinessEventConnection();
        ec.setEventHandler(new FlightStatusUpdateEventSubscriber());
        ec.setTimeout(12000);
        String namespace = "saibot.airport/events/flight";
        String eventName = "FlightStatusUpdateEvent";
        ec.subscribe(new QName(namespace, eventName), "mySubscriptionForFlightStatusUpdateEvent");
    }

    @Override
    public void onEvent(BusinessEvent businessEvent) throws FabricInvocationException {
        System.out.println("Hey, I received an event of type " + businessEvent.getEventName());
        System.out.println(businessEvent.getBodyAsText());
    }
}
