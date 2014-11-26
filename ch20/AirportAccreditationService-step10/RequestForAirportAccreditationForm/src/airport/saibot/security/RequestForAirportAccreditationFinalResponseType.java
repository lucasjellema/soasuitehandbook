
package airport.saibot.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpm.datacontrol.caseservice.DataObject;


/**
 * <p>Java class for requestForAirportAccreditationFinalResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestForAirportAccreditationFinalResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AirportAccreditationRequestIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmployeeNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StaffMemberUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BadgeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutcomeOfAccreditationRequest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Motivation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestForAirportAccreditationFinalResponseType", propOrder = {
    "airportAccreditationRequestIdentifier",
    "requestorId",
    "employeeNumber",
    "staffMemberUserId",
    "badgeNumber",
    "outcomeOfAccreditationRequest",
    "motivation"
})
public class RequestForAirportAccreditationFinalResponseType
    extends DataObject
{

    @XmlElement(name = "AirportAccreditationRequestIdentifier", required = true)
    protected String airportAccreditationRequestIdentifier;
    @XmlElement(name = "RequestorId", required = true)
    protected String requestorId;
    @XmlElement(name = "EmployeeNumber", required = true)
    protected String employeeNumber;
    @XmlElement(name = "StaffMemberUserId")
    protected String staffMemberUserId;
    @XmlElement(name = "BadgeNumber")
    protected String badgeNumber;
    @XmlElement(name = "OutcomeOfAccreditationRequest", required = true)
    protected String outcomeOfAccreditationRequest;
    @XmlElement(name = "Motivation")
    protected String motivation;

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
     * Gets the value of the staffMemberUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffMemberUserId() {
        return staffMemberUserId;
    }

    /**
     * Sets the value of the staffMemberUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffMemberUserId(String value) {
        this.staffMemberUserId = value;
    }

    /**
     * Gets the value of the badgeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadgeNumber() {
        return badgeNumber;
    }

    /**
     * Sets the value of the badgeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadgeNumber(String value) {
        this.badgeNumber = value;
    }

    /**
     * Gets the value of the outcomeOfAccreditationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcomeOfAccreditationRequest() {
        return outcomeOfAccreditationRequest;
    }

    /**
     * Sets the value of the outcomeOfAccreditationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcomeOfAccreditationRequest(String value) {
        this.outcomeOfAccreditationRequest = value;
    }

    /**
     * Gets the value of the motivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivation() {
        return motivation;
    }

    /**
     * Sets the value of the motivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivation(String value) {
        this.motivation = value;
    }

}
