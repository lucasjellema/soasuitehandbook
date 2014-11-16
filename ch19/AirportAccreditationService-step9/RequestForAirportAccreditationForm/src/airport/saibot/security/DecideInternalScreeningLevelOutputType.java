
package airport.saibot.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpm.datacontrol.caseservice.DataObject;


/**
 * <p>Java class for decideInternalScreeningLevelOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="decideInternalScreeningLevelOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternalScrutinyLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decideInternalScreeningLevelOutputType", propOrder = {
    "internalScrutinyLevel"
})
public class DecideInternalScreeningLevelOutputType
    extends DataObject
{

    @XmlElement(name = "InternalScrutinyLevel")
    protected int internalScrutinyLevel;

    /**
     * Gets the value of the internalScrutinyLevel property.
     * 
     */
    public int getInternalScrutinyLevel() {
        return internalScrutinyLevel;
    }

    /**
     * Sets the value of the internalScrutinyLevel property.
     * 
     */
    public void setInternalScrutinyLevel(int value) {
        this.internalScrutinyLevel = value;
    }

}
