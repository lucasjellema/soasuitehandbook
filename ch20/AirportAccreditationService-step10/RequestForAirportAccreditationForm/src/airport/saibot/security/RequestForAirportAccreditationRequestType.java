
package airport.saibot.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import oracle.bpm.datacontrol.caseservice.DataObject;
import oracle.bpm.datacontrol.type.adapter.DtAdapter;


/**
 * <p>Java class for requestForAirportAccreditationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestForAirportAccreditationRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestingOrganizationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StaffMemberToAccredit" type="{saibot.airport/security}staffMemberType"/>
 *         &lt;element name="RequiredSecurityLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Motivation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StaffReferences" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StaffMemberId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestForAirportAccreditationRequestType", propOrder = {
    "requestingOrganizationId",
    "requestorId",
    "staffMemberToAccredit",
    "requiredSecurityLevel",
    "startDate",
    "endDate",
    "motivation",
    "staffReferences"
})
public class RequestForAirportAccreditationRequestType
    extends DataObject
{

    @XmlElement(name = "RequestingOrganizationId", required = true)
    protected String requestingOrganizationId;
    @XmlElement(name = "RequestorId", required = true)
    protected String requestorId;
    @XmlElement(name = "StaffMemberToAccredit", required = true)
    protected StaffMemberType staffMemberToAccredit;
    @XmlElement(name = "RequiredSecurityLevel")
    protected int requiredSecurityLevel;
    @XmlElement(name = "StartDate", required = true, type = String.class)
    @XmlJavaTypeAdapter(DtAdapter.class)
    @XmlSchemaType(name = "date")
    protected Date startDate;
    @XmlElement(name = "EndDate")
    protected Integer endDate;
    @XmlElement(name = "Motivation")
    protected String motivation;
    @XmlElement(name = "StaffReferences")
    protected RequestForAirportAccreditationRequestType.StaffReferences staffReferences;

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
     * Gets the value of the staffMemberToAccredit property.
     * 
     * @return
     *     possible object is
     *     {@link StaffMemberType }
     *     
     */
    public StaffMemberType getStaffMemberToAccredit() {
        return staffMemberToAccredit;
    }

    /**
     * Sets the value of the staffMemberToAccredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffMemberType }
     *     
     */
    public void setStaffMemberToAccredit(StaffMemberType value) {
        this.staffMemberToAccredit = value;
    }

    /**
     * Gets the value of the requiredSecurityLevel property.
     * 
     */
    public int getRequiredSecurityLevel() {
        return requiredSecurityLevel;
    }

    /**
     * Sets the value of the requiredSecurityLevel property.
     * 
     */
    public void setRequiredSecurityLevel(int value) {
        this.requiredSecurityLevel = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(Date value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEndDate(Integer value) {
        this.endDate = value;
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

    /**
     * Gets the value of the staffReferences property.
     * 
     * @return
     *     possible object is
     *     {@link RequestForAirportAccreditationRequestType.StaffReferences }
     *     
     */
    public RequestForAirportAccreditationRequestType.StaffReferences getStaffReferences() {
        return staffReferences;
    }

    /**
     * Sets the value of the staffReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestForAirportAccreditationRequestType.StaffReferences }
     *     
     */
    public void setStaffReferences(RequestForAirportAccreditationRequestType.StaffReferences value) {
        this.staffReferences = value;
    }


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
     *         &lt;element name="StaffMemberId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "staffMemberId"
    })
    public static class StaffReferences
        extends DataObject
    {

        @XmlElement(name = "StaffMemberId")
        protected List<String> staffMemberId;

        /**
         * Gets the value of the staffMemberId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the staffMemberId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStaffMemberId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getStaffMemberId() {
            if (staffMemberId == null) {
                staffMemberId = new ArrayList<String>();
            }
            return this.staffMemberId;
        }

    }

}
