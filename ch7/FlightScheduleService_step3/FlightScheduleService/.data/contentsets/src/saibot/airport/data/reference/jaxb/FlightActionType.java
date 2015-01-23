
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightActionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="flightActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EnRoute"/>
 *     &lt;enumeration value="FinalApproach"/>
 *     &lt;enumeration value="Taxiing"/>
 *     &lt;enumeration value="AtGate"/>
 *     &lt;enumeration value="BagageOnBelt"/>
 *     &lt;enumeration value="Prepare"/>
 *     &lt;enumeration value="GateOpen"/>
 *     &lt;enumeration value="GateClosing"/>
 *     &lt;enumeration value="GateClosed"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "flightActionType", namespace = "saibot.airport/data/common")
@XmlEnum
public enum FlightActionType {

    @XmlEnumValue("EnRoute")
    EN_ROUTE("EnRoute"),
    @XmlEnumValue("FinalApproach")
    FINAL_APPROACH("FinalApproach"),
    @XmlEnumValue("Taxiing")
    TAXIING("Taxiing"),
    @XmlEnumValue("AtGate")
    AT_GATE("AtGate"),
    @XmlEnumValue("BagageOnBelt")
    BAGAGE_ON_BELT("BagageOnBelt"),
    @XmlEnumValue("Prepare")
    PREPARE("Prepare"),
    @XmlEnumValue("GateOpen")
    GATE_OPEN("GateOpen"),
    @XmlEnumValue("GateClosing")
    GATE_CLOSING("GateClosing"),
    @XmlEnumValue("GateClosed")
    GATE_CLOSED("GateClosed"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    FlightActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FlightActionType fromValue(String v) {
        for (FlightActionType c : FlightActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
