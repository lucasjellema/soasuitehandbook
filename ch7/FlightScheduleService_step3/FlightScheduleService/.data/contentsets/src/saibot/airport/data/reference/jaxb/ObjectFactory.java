
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the saibot.airport.data.reference.jaxb package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TimePlanningUnit_QNAME = new QName("saibot.airport/data/reference", "TimePlanningUnit");
    private final static QName _TimePlanningUnitTypeEndDate_QNAME =
        new QName("saibot.airport/data/reference", "endDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: saibot.airport.data.reference.jaxb
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TimePlanningUnitType }
     *
     */
    public TimePlanningUnitType createTimePlanningUnitType() {
        return new TimePlanningUnitType();
    }

    /**
     * Create an instance of {@link AircraftModelType }
     *
     */
    public AircraftModelType createAircraftModelType() {
        return new AircraftModelType();
    }

    /**
     * Create an instance of {@link AircraftType }
     *
     */
    public AircraftType createAircraftType() {
        return new AircraftType();
    }

    /**
     * Create an instance of {@link AircarrierType }
     *
     */
    public AircarrierType createAircarrierType() {
        return new AircarrierType();
    }

    /**
     * Create an instance of {@link CountryType }
     *
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link AirportType }
     *
     */
    public AirportType createAirportType() {
        return new AirportType();
    }

    /**
     * Create an instance of {@link GateLocationType }
     *
     */
    public GateLocationType createGateLocationType() {
        return new GateLocationType();
    }

    /**
     * Create an instance of {@link WeatherReportType }
     *
     */
    public WeatherReportType createWeatherReportType() {
        return new WeatherReportType();
    }

    /**
     * Create an instance of {@link GeoLocationType }
     *
     */
    public GeoLocationType createGeoLocationType() {
        return new GeoLocationType();
    }

    /**
     * Create an instance of {@link SearchMetaType }
     *
     */
    public SearchMetaType createSearchMetaType() {
        return new SearchMetaType();
    }

    /**
     * Create an instance of {@link PeriodType }
     *
     */
    public PeriodType createPeriodType() {
        return new PeriodType();
    }

    /**
     * Create an instance of {@link TimePlanningUnitType.DaysOfWeek }
     *
     */
    public TimePlanningUnitType.DaysOfWeek createTimePlanningUnitTypeDaysOfWeek() {
        return new TimePlanningUnitType.DaysOfWeek();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePlanningUnitType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "saibot.airport/data/reference", name = "TimePlanningUnit")
    public JAXBElement<TimePlanningUnitType> createTimePlanningUnit(TimePlanningUnitType value) {
        return new JAXBElement<TimePlanningUnitType>(_TimePlanningUnit_QNAME, TimePlanningUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "saibot.airport/data/reference", name = "endDate", scope = TimePlanningUnitType.class)
    public JAXBElement<XMLGregorianCalendar> createTimePlanningUnitTypeEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TimePlanningUnitTypeEndDate_QNAME, XMLGregorianCalendar.class,
                                                     TimePlanningUnitType.class, value);
    }

}
