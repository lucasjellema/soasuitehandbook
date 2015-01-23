
package saibot.airport.data.reference.jaxb;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for weatherReportType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="weatherReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WindSpeed" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="WindDirection" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="DewPointTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CurrentTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pressure" type="{saibot.airport/data/reference}countryType" minOccurs="0"/>
 *         &lt;element name="SkyCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Visibility" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Precipitation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Obscuration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weatherReportType", propOrder = {
         "windSpeed", "windDirection", "dewPointTemperature", "currentTemperature", "pressure", "skyCondition",
         "visibility", "precipitation", "obscuration"
    })
public class WeatherReportType {

    @XmlElement(name = "WindSpeed")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger windSpeed;
    @XmlElement(name = "WindDirection")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger windDirection;
    @XmlElement(name = "DewPointTemperature")
    protected double dewPointTemperature;
    @XmlElement(name = "CurrentTemperature")
    protected double currentTemperature;
    @XmlElement(name = "Pressure")
    protected CountryType pressure;
    @XmlElement(name = "SkyCondition")
    protected String skyCondition;
    @XmlElement(name = "Visibility")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger visibility;
    @XmlElement(name = "Precipitation")
    protected String precipitation;
    @XmlElement(name = "Obscuration")
    protected String obscuration;

    /**
     * Gets the value of the windSpeed property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setWindSpeed(BigInteger value) {
        this.windSpeed = value;
    }

    /**
     * Gets the value of the windDirection property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getWindDirection() {
        return windDirection;
    }

    /**
     * Sets the value of the windDirection property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setWindDirection(BigInteger value) {
        this.windDirection = value;
    }

    /**
     * Gets the value of the dewPointTemperature property.
     *
     */
    public double getDewPointTemperature() {
        return dewPointTemperature;
    }

    /**
     * Sets the value of the dewPointTemperature property.
     *
     */
    public void setDewPointTemperature(double value) {
        this.dewPointTemperature = value;
    }

    /**
     * Gets the value of the currentTemperature property.
     *
     */
    public double getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * Sets the value of the currentTemperature property.
     *
     */
    public void setCurrentTemperature(double value) {
        this.currentTemperature = value;
    }

    /**
     * Gets the value of the pressure property.
     *
     * @return
     *     possible object is
     *     {@link CountryType }
     *
     */
    public CountryType getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     *
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *
     */
    public void setPressure(CountryType value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the skyCondition property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSkyCondition() {
        return skyCondition;
    }

    /**
     * Sets the value of the skyCondition property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSkyCondition(String value) {
        this.skyCondition = value;
    }

    /**
     * Gets the value of the visibility property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVisibility(BigInteger value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the precipitation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets the value of the precipitation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrecipitation(String value) {
        this.precipitation = value;
    }

    /**
     * Gets the value of the obscuration property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getObscuration() {
        return obscuration;
    }

    /**
     * Sets the value of the obscuration property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setObscuration(String value) {
        this.obscuration = value;
    }

}
