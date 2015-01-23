
package saibot.airport.data.reference.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for airportType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="airportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IATACode" type="{saibot.airport/data/common}iataAirportType" minOccurs="0"/>
 *         &lt;element name="ICAOCode" type="{saibot.airport/data/common}iacoCodeType" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Country" type="{saibot.airport/data/reference}countryType" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GeoLocation" type="{saibot.airport/data/common}geoLocationType" minOccurs="0"/>
 *         &lt;element name="UTCOffset" type="{saibot.airport/data/common}timezoneOffsetType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "airportType", propOrder = {
         "iataCode", "icaoCode", "name", "country", "city", "geoLocation", "utcOffset" })
public class AirportType {

    @XmlElement(name = "IATACode")
    protected String iataCode;
    @XmlElement(name = "ICAOCode")
    protected String icaoCode;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Country")
    protected CountryType country;
    @XmlElement(name = "City")
    protected List<String> city;
    @XmlElement(name = "GeoLocation")
    protected GeoLocationType geoLocation;
    @XmlElement(name = "UTCOffset")
    protected Float utcOffset;

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
     * Gets the value of the icaoCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getICAOCode() {
        return icaoCode;
    }

    /**
     * Sets the value of the icaoCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setICAOCode(String value) {
        this.icaoCode = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link CountryType }
     *
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Gets the value of the city property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the city property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCity().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getCity() {
        if (city == null) {
            city = new ArrayList<String>();
        }
        return this.city;
    }

    /**
     * Gets the value of the geoLocation property.
     *
     * @return
     *     possible object is
     *     {@link GeoLocationType }
     *
     */
    public GeoLocationType getGeoLocation() {
        return geoLocation;
    }

    /**
     * Sets the value of the geoLocation property.
     *
     * @param value
     *     allowed object is
     *     {@link GeoLocationType }
     *
     */
    public void setGeoLocation(GeoLocationType value) {
        this.geoLocation = value;
    }

    /**
     * Gets the value of the utcOffset property.
     *
     * @return
     *     possible object is
     *     {@link Float }
     *
     */
    public Float getUTCOffset() {
        return utcOffset;
    }

    /**
     * Sets the value of the utcOffset property.
     *
     * @param value
     *     allowed object is
     *     {@link Float }
     *
     */
    public void setUTCOffset(Float value) {
        this.utcOffset = value;
    }

}
