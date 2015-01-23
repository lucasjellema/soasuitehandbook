
package saibot.airport.data.reference.jaxb;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aircarrierType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="aircarrierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IATACode" type="{saibot.airport/data/common}alpha2Type" minOccurs="0"/>
 *         &lt;element name="PAXCode" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="ICAOCode" type="{saibot.airport/data/common}alphaNumeric4Type" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Country" type="{saibot.airport/data/reference}countryType" minOccurs="0"/>
 *         &lt;element name="Logo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aircarrierType", propOrder = { "iataCode", "paxCode", "icaoCode", "name", "country", "logo" })
public class AircarrierType {

    @XmlElement(name = "IATACode")
    protected String iataCode;
    @XmlElement(name = "PAXCode")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger paxCode;
    @XmlElement(name = "ICAOCode")
    protected String icaoCode;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Country")
    protected CountryType country;
    @XmlElement(name = "Logo")
    protected byte[] logo;

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
     * Gets the value of the paxCode property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPAXCode() {
        return paxCode;
    }

    /**
     * Sets the value of the paxCode property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPAXCode(BigInteger value) {
        this.paxCode = value;
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
     * Gets the value of the logo property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setLogo(byte[] value) {
        this.logo = value;
    }

}
