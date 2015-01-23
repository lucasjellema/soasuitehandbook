package saibot.airport.flightscheduleservice;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.xmlbeans.XmlObject;

import saibot.airport.data.reference.jaxb.TimePlanningUnitType;


public class ScheduledFlightProcessor {

    public static int calculateNumberOfFlights(XmlObject timePlanningUnit) {
        int numberOfFlights = 0;
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(TimePlanningUnitType.class);
            Unmarshaller unmarshaller;
            String xml = timePlanningUnit.toString();
            // this string starts with <xml-fragment xmlns:ref="saibot.airport/data/reference" xmlns:flig="saibot.airport/services/flightschedule">
            // the xml-fragment has to be replaced with ref:TimePlanningUnit
            xml = xml.replaceAll("xml-fragment", "ref:TimePlanningUnit");
            unmarshaller = jc.createUnmarshaller();
            byte[] bytes = xml.getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            TimePlanningUnitType tpu = (TimePlanningUnitType) ((JAXBElement) unmarshaller.unmarshal(bais)).getValue();
            XMLGregorianCalendar startDate = tpu.getStartDate();
            if (tpu.getEndDate() == null) {
                numberOfFlights = 1;
            } else {
                XMLGregorianCalendar endDate = tpu.getEndDate().getValue();
                if (endDate.equals(startDate)) {
                    numberOfFlights = 1;
                } else {
                    System.out.println("startdate  " + tpu.getStartDate().toString());
                    System.out.println("End date " + tpu.getEndDate().getValue().toString());
                    System.out.println(endDate.toGregorianCalendar().getTimeInMillis() - startDate.toGregorianCalendar().getTimeInMillis());
                    int diffInDays = (int)Math.ceil((endDate.toGregorianCalendar().getTimeInMillis() - startDate.toGregorianCalendar().getTimeInMillis())/(1000*60*60*24));
                    System.out.println("Diff in days "+diffInDays);
                    // determine number of days per week
                    int daysPerWeek = tpu.getDaysOfWeek().getDay().size();
                    numberOfFlights = (diffInDays* daysPerWeek/7);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        System.out.println("Number of flights = "+numberOfFlights);
        System.out.println("Sleep");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println("Awake");
        return numberOfFlights;
    }
}
