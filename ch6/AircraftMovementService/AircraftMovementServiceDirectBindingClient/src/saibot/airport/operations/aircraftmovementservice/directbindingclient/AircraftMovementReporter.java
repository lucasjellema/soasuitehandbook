package saibot.airport.operations.aircraftmovementservice.directbindingclient;

import java.io.StringReader;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import javax.naming.Context;


import oracle.soa.api.JNDIDirectConnectionFactory;
import oracle.soa.api.PayloadFactory;
import oracle.soa.api.XMLMessageFactory;
import oracle.soa.api.invocation.DirectConnection;
import oracle.soa.api.invocation.DirectConnectionFactory;
import oracle.soa.api.message.Message;
import oracle.soa.api.message.Payload;
import oracle.soa.management.CompositeDN;
import oracle.soa.management.facade.Locator;

import oracle.soa.management.facade.LocatorFactory;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLPrintDriver;

import org.w3c.dom.Element;

import org.xml.sax.InputSource;

import saibot.airport.operations.aircraftmovementservice.AircraftMovement;

public class AircraftMovementReporter {
    public AircraftMovementReporter() {
        super();
    }

    public void ReportAircraftMovement(AircraftMovement aircraftMovement) {
        //
        // create a direct connection to the composite
        //
        Hashtable jndiProps = new Hashtable();
        //jndiProps.put(Context.PROVIDER_URL, "t3://localhost:7101/soa-infra");
        jndiProps.put(Context.PROVIDER_URL, "t3://soa2admin2:8001/soa-infra");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        jndiProps.put("dedicated.connection", "true");

        Locator locator = null;
        try {
            locator = LocatorFactory.createLocator(jndiProps);
            DirectConnectionFactory factory = JNDIDirectConnectionFactory.newInstance();

            CompositeDN compositeDN = new CompositeDN("default", "AircraftMovementServiceSOAcomposite", "1.0");
            String serviceName = "AircraftMovementServiceDirectBinding";
           // String serviceName = "AircraftMovementMediator_2";
            // String serviceAddress = "soadirect:/default/AircraftMovementServiceSOAcomposite!1.1/AircraftMovementServiceDirectBinding";
            // DirectConnection dc = factory.createConnection(serviceAddress, jndiProps);
            DirectConnection dc = locator.createDirectConnection(compositeDN, serviceName);

            String inputPayload =
                "<ns1:reportAircraftMovementRequestMessage xmlns:ns1=\"saibot.airport/services/aircraftmovement\">\n" +
                "                                  <ns1:ActionDateAndTime>"+ aircraftMovement.getMovementTimestamp() +"</ns1:ActionDateAndTime>\n" +
                "                                  <ns1:FlightNumber>"+ aircraftMovement.getFlightnumber() +"</ns1:FlightNumber>\n" +
                "                                  <ns1:Carrier>"+ aircraftMovement.getCarrierIataCode() +"</ns1:Carrier>\n" +
                "                                  <ns1:ArrivalOrDeparture>"+ aircraftMovement.getArrivalOrDeparture() +"</ns1:ArrivalOrDeparture>\n" +
                "                                  <ns1:ConnectingAirport>"+ aircraftMovement.getAirportIataCode() +"</ns1:ConnectingAirport>\n" +
                "                                  <ns1:AircraftModel>"+ aircraftMovement.getAircraftIataEquipmentCode() +"</ns1:AircraftModel>\n" +
                "                                  <ns1:NumberOfPassengers>"+ aircraftMovement.getNumberOfPassengers() +"</ns1:NumberOfPassengers>\n" +
                "        </ns1:reportAircraftMovementRequestMessage>";


            oracle.xml.parser.v2.DOMParser op = new DOMParser();
            op.parse(new InputSource(new StringReader(inputPayload)));

            // just a print to check it
            XMLPrintDriver pd = new XMLPrintDriver(System.out);
            pd.setFormatPrettyPrint(true);
            pd.printDocument(op.getDocument());

            Map partData = new HashMap();
            partData.put("part1", op.getDocument().getDocumentElement());

            // Create the Message and pass in the payload
            Payload payload = PayloadFactory.createXMLPayload(partData);

            Message request = XMLMessageFactory.getInstance().createMessage();
            request.setPayload(payload);

            // Define conversation ID
            String uuid = "uuid:" + UUID.randomUUID();
            System.out.println("uuid = " + uuid);
            request.setProperty(request.CONVERSATION_ID, uuid);

            // Invoke...
            dc.post("reportAircraftMovement", request);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AircraftMovementReporter().ReportAircraftMovement( new AircraftMovement(new Date(), 450, "AZQ", "DUB", "A", "726", 159));
    }
}
