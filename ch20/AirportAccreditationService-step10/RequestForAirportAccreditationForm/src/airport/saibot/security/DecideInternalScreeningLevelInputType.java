
package airport.saibot.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpm.datacontrol.caseservice.DataObject;


/**
 * <p>Java class for decideInternalScreeningLevelInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="decideInternalScreeningLevelInputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestingOrganizationSASECLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RequestorSASECLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RequiredSecurityLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decideInternalScreeningLevelInputType", propOrder = {
    "requestingOrganizationSASECLevel",
    "requestorSASECLevel",
    "requiredSecurityLevel"
})
public class DecideInternalScreeningLevelInputType
    extends DataObject
{

    @XmlElement(name = "RequestingOrganizationSASECLevel")
    protected int requestingOrganizationSASECLevel;
    @XmlElement(name = "RequestorSASECLevel")
    protected int requestorSASECLevel;
    @XmlElement(name = "RequiredSecurityLevel")
    protected int requiredSecurityLevel;

    /**
     * Gets the value of the requestingOrganizationSASECLevel property.
     * 
     */
    public int getRequestingOrganizationSASECLevel() {
        return requestingOrganizationSASECLevel;
    }

    /**
     * Sets the value of the requestingOrganizationSASECLevel property.
     * 
     */
    public void setRequestingOrganizationSASECLevel(int value) {
        this.requestingOrganizationSASECLevel = value;
    }

    /**
     * Gets the value of the requestorSASECLevel property.
     * 
     */
    public int getRequestorSASECLevel() {
        return requestorSASECLevel;
    }

    /**
     * Sets the value of the requestorSASECLevel property.
     * 
     */
    public void setRequestorSASECLevel(int value) {
        this.requestorSASECLevel = value;
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

}
