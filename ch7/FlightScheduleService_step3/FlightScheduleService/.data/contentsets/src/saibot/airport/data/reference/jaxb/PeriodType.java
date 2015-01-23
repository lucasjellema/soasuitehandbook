
package saibot.airport.data.reference.jaxb;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for periodType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="periodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="season" type="{saibot.airport/data/common}seasonType"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodType", namespace = "saibot.airport/data/common", propOrder = { "season", "year" })
public class PeriodType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SeasonType season;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger year;

    /**
     * Gets the value of the season property.
     *
     * @return
     *     possible object is
     *     {@link SeasonType }
     *
     */
    public SeasonType getSeason() {
        return season;
    }

    /**
     * Sets the value of the season property.
     *
     * @param value
     *     allowed object is
     *     {@link SeasonType }
     *
     */
    public void setSeason(SeasonType value) {
        this.season = value;
    }

    /**
     * Gets the value of the year property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setYear(BigInteger value) {
        this.year = value;
    }

}
