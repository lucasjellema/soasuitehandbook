
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gateLocationType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="gateLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Terminal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gateLocationType", propOrder = { "terminal", "pier", "gate" })
public class GateLocationType {

    @XmlElement(name = "Terminal")
    protected String terminal;
    @XmlElement(name = "Pier")
    protected String pier;
    @XmlElement(name = "Gate")
    protected String gate;

    /**
     * Gets the value of the terminal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminal(String value) {
        this.terminal = value;
    }

    /**
     * Gets the value of the pier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPier() {
        return pier;
    }

    /**
     * Sets the value of the pier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPier(String value) {
        this.pier = value;
    }

    /**
     * Gets the value of the gate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGate() {
        return gate;
    }

    /**
     * Sets the value of the gate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGate(String value) {
        this.gate = value;
    }

}
