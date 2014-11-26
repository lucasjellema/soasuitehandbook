
package airport.saibot.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpm.datacontrol.caseservice.DataObject;


/**
 * <p>Java class for staffMemberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="staffMemberType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmployeeNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ManagerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobileTelephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FunctionTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdentityDetails" type="{saibot.airport/security}staffIdentityDetailsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "staffMemberType", propOrder = {
    "firstName",
    "lastName",
    "emailAddress",
    "employeeNumber",
    "managerId",
    "mobileTelephone",
    "functionTitle",
    "identityDetails"
})
public class StaffMemberType
    extends DataObject
{

    @XmlElement(name = "FirstName", required = true)
    protected String firstName;
    @XmlElement(name = "LastName", required = true)
    protected String lastName;
    @XmlElement(name = "EmailAddress", required = true)
    protected String emailAddress;
    @XmlElement(name = "EmployeeNumber", required = true)
    protected String employeeNumber;
    @XmlElement(name = "ManagerId")
    protected String managerId;
    @XmlElement(name = "MobileTelephone", required = true)
    protected String mobileTelephone;
    @XmlElement(name = "FunctionTitle", required = true)
    protected String functionTitle;
    @XmlElement(name = "IdentityDetails", required = true)
    protected StaffIdentityDetailsType identityDetails;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
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
     * Gets the value of the managerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * Sets the value of the managerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerId(String value) {
        this.managerId = value;
    }

    /**
     * Gets the value of the mobileTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileTelephone() {
        return mobileTelephone;
    }

    /**
     * Sets the value of the mobileTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileTelephone(String value) {
        this.mobileTelephone = value;
    }

    /**
     * Gets the value of the functionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionTitle() {
        return functionTitle;
    }

    /**
     * Sets the value of the functionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionTitle(String value) {
        this.functionTitle = value;
    }

    /**
     * Gets the value of the identityDetails property.
     * 
     * @return
     *     possible object is
     *     {@link StaffIdentityDetailsType }
     *     
     */
    public StaffIdentityDetailsType getIdentityDetails() {
        return identityDetails;
    }

    /**
     * Sets the value of the identityDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffIdentityDetailsType }
     *     
     */
    public void setIdentityDetails(StaffIdentityDetailsType value) {
        this.identityDetails = value;
    }

}
