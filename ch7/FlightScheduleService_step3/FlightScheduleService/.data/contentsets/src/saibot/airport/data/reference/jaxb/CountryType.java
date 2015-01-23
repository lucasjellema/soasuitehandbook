
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countryType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="countryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{saibot.airport/data/common}alpha2Type" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tailcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countryType", propOrder = { "code", "name", "tailcode", "flag" })
public class CountryType {

    protected String code;
    protected String name;
    protected String tailcode;
    @XmlElement(name = "Flag")
    protected byte[] flag;

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCode(String value) {
        this.code = value;
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
     * Gets the value of the tailcode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTailcode() {
        return tailcode;
    }

    /**
     * Sets the value of the tailcode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTailcode(String value) {
        this.tailcode = value;
    }

    /**
     * Gets the value of the flag property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFlag(byte[] value) {
        this.flag = value;
    }

}
