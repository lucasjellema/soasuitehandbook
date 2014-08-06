package saibot.airport.operations.client;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import saibot.airport.operations.monitoring.AircraftMovementReporter;
import saibot.airport.operations.monitoring.beans.AircraftMovement;

public class AircraftMovementServiceEJBClient {
    public AircraftMovementServiceEJBClient() {
        super();
    }

    public void reportAircraftMovement(AircraftMovement aircraftMovement) {
       
        try{
        Hashtable jndiProps = new Hashtable();
//            jndiProps.put(Context.PROVIDER_URL, "t3://localhost:7101/soa-infra");
            jndiProps.put(Context.PROVIDER_URL, "t3://soa2admin2:8011");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        InitialContext ic = new InitialContext(jndiProps);
        AircraftMovementReporter aircraftMovementReporter = (AircraftMovementReporter)ic.lookup("AircraftMovementServiceJEJB#saibot.airport.operations.monitoring.AircraftMovementReporter");
        aircraftMovementReporter.reportAircraftActivity(aircraftMovement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AircraftMovementServiceEJBClient().reportAircraftMovement( new AircraftMovement(new Date(), 450, "AZQ", "DUB", "A", "726", 159));
    }
}
