
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrivalOrDepartureType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="arrivalOrDepartureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="D"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "arrivalOrDepartureType", namespace = "saibot.airport/data/common")
@XmlEnum
public enum ArrivalOrDepartureType {

    A,
    D;

    public String value() {
        return name();
    }

    public static ArrivalOrDepartureType fromValue(String v) {
        return valueOf(v);
    }

}
