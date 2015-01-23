
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for aircraftType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="aircraftType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aircraftModel" type="{saibot.airport/data/reference}aircraftModelType" minOccurs="0"/>
 *         &lt;element name="Registration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LaunchDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aircraftType", propOrder = { "aircraftModel", "registration", "launchDate" })
public class AircraftType {

    protected AircraftModelType aircraftModel;
    @XmlElement(name = "Registration", required = true)
    protected String registration;
    @XmlElement(name = "LaunchDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar launchDate;

    /**
     * Gets the value of the aircraftModel property.
     *
     * @return
     *     possible object is
     *     {@link AircraftModelType }
     *
     */
    public AircraftModelType getAircraftModel() {
        return aircraftModel;
    }

    /**
     * Sets the value of the aircraftModel property.
     *
     * @param value
     *     allowed object is
     *     {@link AircraftModelType }
     *
     */
    public void setAircraftModel(AircraftModelType value) {
        this.aircraftModel = value;
    }

    /**
     * Gets the value of the registration property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegistration(String value) {
        this.registration = value;
    }

    /**
     * Gets the value of the launchDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getLaunchDate() {
        return launchDate;
    }

    /**
     * Sets the value of the launchDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setLaunchDate(XMLGregorianCalendar value) {
        this.launchDate = value;
    }

}
