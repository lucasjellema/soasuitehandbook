
package airport.saibot.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpm.datacontrol.caseservice.DataObject;


/**
 * <p>Java class for AirportAccreditationProcessStateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AirportAccreditationProcessStateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestingOrganizationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmployeeNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BadgeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestorEmailId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestorSASEC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompanySASEC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AirportAccreditationRequestIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AirportAccreditationProcessStateType", propOrder = {
    "requestingOrganizationId",
    "requestorId",
    "employeeNumber",
    "badgeId",
    "requestorEmailId",
    "requestorSASEC",
    "companySASEC",
    "airportAccreditationRequestIdentifier"
})
public class AirportAccreditationProcessStateType
    extends DataObject
{

    @XmlElement(name = "RequestingOrganizationId", required = true)
    protected String requestingOrganizationId;
    @XmlElement(name = "RequestorId", required = true)
    protected String requestorId;
    @XmlElement(name = "EmployeeNumber", required = true)
    protected String employeeNumber;
    @XmlElement(name = "BadgeId", required = true)
    protected String badgeId;
    @XmlElement(name = "RequestorEmailId", required = true)
    protected String requestorEmailId;
    @XmlElement(name = "RequestorSASEC", required = true)
    protected String requestorSASEC;
    @XmlElement(name = "CompanySASEC", required = true)
    protected String companySASEC;
    @XmlElement(name = "AirportAccreditationRequestIdentifier", required = true)
    protected String airportAccreditationRequestIdentifier;

    /**
     * Gets the value of the requestingOrganizationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestingOrganizationId() {
        return requestingOrganizationId;
    }

    /**
     * Sets the value of the requestingOrganizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestingOrganizationId(String value) {
        this.requestingOrganizationId = value;
    }

    /**
     * Gets the value of the requestorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorId() {
        return requestorId;
    }

    /**
     * Sets the value of the requestorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorId(String value) {
        this.requestorId = value;
    }

    /**
     * Gets the value of the employeeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Sets the value of the employeeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeNumber(String value) {
        this.employeeNumber = value;
    }

    /**
     * Gets the value of the badgeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadgeId() {
        return badgeId;
    }

    /**
     * Sets the value of the badgeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadgeId(String value) {
        this.badgeId = value;
    }

    /**
     * Gets the value of the requestorEmailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorEmailId() {
        return requestorEmailId;
    }

    /**
     * Sets the value of the requestorEmailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorEmailId(String value) {
        this.requestorEmailId = value;
    }

    /**
     * Gets the value of the requestorSASEC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorSASEC() {
        return requestorSASEC;
    }

    /**
     * Sets the value of the requestorSASEC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorSASEC(String value) {
        this.requestorSASEC = value;
    }

    /**
     * Gets the value of the companySASEC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanySASEC() {
        return companySASEC;
    }

    /**
     * Sets the value of the companySASEC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanySASEC(String value) {
        this.companySASEC = value;
    }

    /**
     * Gets the value of the airportAccreditationRequestIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirportAccreditationRequestIdentifier() {
        return airportAccreditationRequestIdentifier;
    }

    /**
     * Sets the value of the airportAccreditationRequestIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirportAccreditationRequestIdentifier(String value) {
        this.airportAccreditationRequestIdentifier = value;
    }

}
