
package saibot.airport.data.reference.jaxb;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aircraftModelType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="aircraftModelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IATACode" type="{saibot.airport/data/common}iataEquipmentCodeType" minOccurs="0"/>
 *         &lt;element name="IACOCode" type="{saibot.airport/data/common}iacoCodeType" minOccurs="0"/>
 *         &lt;element name="Manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WakeCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PassengerCapacity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="RangeInKilometers" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="CruiseSpeedInKilolmetersPerHour" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="LengthInMeters" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="HeightInMeters" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="WingSpanInMeters" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="MaximumTakeOffWeightInKilogram" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aircraftModelType", propOrder = {
         "iataCode", "iacoCode", "manufacturer", "model", "wakeCategory", "passengerCapacity", "rangeInKilometers",
         "cruiseSpeedInKilolmetersPerHour", "lengthInMeters", "heightInMeters", "wingSpanInMeters",
         "maximumTakeOffWeightInKilogram"
    })
public class AircraftModelType {

    @XmlElement(name = "IATACode")
    protected String iataCode;
    @XmlElement(name = "IACOCode")
    protected String iacoCode;
    @XmlElement(name = "Manufacturer", required = true)
    protected String manufacturer;
    @XmlElement(name = "Model", required = true)
    protected String model;
    @XmlElement(name = "WakeCategory", required = true)
    protected String wakeCategory;
    @XmlElement(name = "PassengerCapacity")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger passengerCapacity;
    @XmlElement(name = "RangeInKilometers")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rangeInKilometers;
    @XmlElement(name = "CruiseSpeedInKilolmetersPerHour")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cruiseSpeedInKilolmetersPerHour;
    @XmlElement(name = "LengthInMeters")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger lengthInMeters;
    @XmlElement(name = "HeightInMeters")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger heightInMeters;
    @XmlElement(name = "WingSpanInMeters")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger wingSpanInMeters;
    @XmlElement(name = "MaximumTakeOffWeightInKilogram")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maximumTakeOffWeightInKilogram;

    /**
     * Gets the value of the iataCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIATACode() {
        return iataCode;
    }

    /**
     * Sets the value of the iataCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIATACode(String value) {
        this.iataCode = value;
    }

    /**
     * Gets the value of the iacoCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIACOCode() {
        return iacoCode;
    }

    /**
     * Sets the value of the iacoCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIACOCode(String value) {
        this.iacoCode = value;
    }

    /**
     * Gets the value of the manufacturer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the model property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the wakeCategory property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWakeCategory() {
        return wakeCategory;
    }

    /**
     * Sets the value of the wakeCategory property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWakeCategory(String value) {
        this.wakeCategory = value;
    }

    /**
     * Gets the value of the passengerCapacity property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Sets the value of the passengerCapacity property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPassengerCapacity(BigInteger value) {
        this.passengerCapacity = value;
    }

    /**
     * Gets the value of the rangeInKilometers property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getRangeInKilometers() {
        return rangeInKilometers;
    }

    /**
     * Sets the value of the rangeInKilometers property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setRangeInKilometers(BigInteger value) {
        this.rangeInKilometers = value;
    }

    /**
     * Gets the value of the cruiseSpeedInKilolmetersPerHour property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getCruiseSpeedInKilolmetersPerHour() {
        return cruiseSpeedInKilolmetersPerHour;
    }

    /**
     * Sets the value of the cruiseSpeedInKilolmetersPerHour property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setCruiseSpeedInKilolmetersPerHour(BigInteger value) {
        this.cruiseSpeedInKilolmetersPerHour = value;
    }

    /**
     * Gets the value of the lengthInMeters property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getLengthInMeters() {
        return lengthInMeters;
    }

    /**
     * Sets the value of the lengthInMeters property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setLengthInMeters(BigInteger value) {
        this.lengthInMeters = value;
    }

    /**
     * Gets the value of the heightInMeters property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getHeightInMeters() {
        return heightInMeters;
    }

    /**
     * Sets the value of the heightInMeters property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setHeightInMeters(BigInteger value) {
        this.heightInMeters = value;
    }

    /**
     * Gets the value of the wingSpanInMeters property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getWingSpanInMeters() {
        return wingSpanInMeters;
    }

    /**
     * Sets the value of the wingSpanInMeters property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setWingSpanInMeters(BigInteger value) {
        this.wingSpanInMeters = value;
    }

    /**
     * Gets the value of the maximumTakeOffWeightInKilogram property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMaximumTakeOffWeightInKilogram() {
        return maximumTakeOffWeightInKilogram;
    }

    /**
     * Sets the value of the maximumTakeOffWeightInKilogram property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMaximumTakeOffWeightInKilogram(BigInteger value) {
        this.maximumTakeOffWeightInKilogram = value;
    }

}
