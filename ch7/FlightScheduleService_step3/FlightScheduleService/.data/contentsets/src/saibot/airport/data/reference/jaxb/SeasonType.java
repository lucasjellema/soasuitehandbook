
package saibot.airport.data.reference.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for seasonType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="seasonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="W"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "seasonType", namespace = "saibot.airport/data/common")
@XmlEnum
public enum SeasonType {

    S,
    W;

    public String value() {
        return name();
    }

    public static SeasonType fromValue(String v) {
        return valueOf(v);
    }

}
