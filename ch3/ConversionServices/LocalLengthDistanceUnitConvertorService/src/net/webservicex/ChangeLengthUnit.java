
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LengthValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fromLengthUnit" type="{http://www.webserviceX.NET/}Lengths"/>
 *         &lt;element name="toLengthUnit" type="{http://www.webserviceX.NET/}Lengths"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "lengthValue", "fromLengthUnit", "toLengthUnit" })
@XmlRootElement(name = "ChangeLengthUnit")
public class ChangeLengthUnit {

    @XmlElement(name = "LengthValue")
    protected double lengthValue;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Lengths fromLengthUnit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Lengths toLengthUnit;

    /**
     * Gets the value of the lengthValue property.
     *
     */
    public double getLengthValue() {
        return lengthValue;
    }

    /**
     * Sets the value of the lengthValue property.
     *
     */
    public void setLengthValue(double value) {
        this.lengthValue = value;
    }

    /**
     * Gets the value of the fromLengthUnit property.
     *
     * @return
     *     possible object is
     *     {@link Lengths }
     *
     */
    public Lengths getFromLengthUnit() {
        return fromLengthUnit;
    }

    /**
     * Sets the value of the fromLengthUnit property.
     *
     * @param value
     *     allowed object is
     *     {@link Lengths }
     *
     */
    public void setFromLengthUnit(Lengths value) {
        this.fromLengthUnit = value;
    }

    /**
     * Gets the value of the toLengthUnit property.
     *
     * @return
     *     possible object is
     *     {@link Lengths }
     *
     */
    public Lengths getToLengthUnit() {
        return toLengthUnit;
    }

    /**
     * Sets the value of the toLengthUnit property.
     *
     * @param value
     *     allowed object is
     *     {@link Lengths }
     *
     */
    public void setToLengthUnit(Lengths value) {
        this.toLengthUnit = value;
    }

}
