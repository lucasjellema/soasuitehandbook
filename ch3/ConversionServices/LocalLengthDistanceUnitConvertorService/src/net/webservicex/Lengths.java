
package net.webservicex;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Lengths.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Lengths">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Angstroms"/>
 *     &lt;enumeration value="Nanometers"/>
 *     &lt;enumeration value="Microinch"/>
 *     &lt;enumeration value="Microns"/>
 *     &lt;enumeration value="Mils"/>
 *     &lt;enumeration value="Millimeters"/>
 *     &lt;enumeration value="Centimeters"/>
 *     &lt;enumeration value="Inches"/>
 *     &lt;enumeration value="Links"/>
 *     &lt;enumeration value="Spans"/>
 *     &lt;enumeration value="Feet"/>
 *     &lt;enumeration value="Cubits"/>
 *     &lt;enumeration value="Varas"/>
 *     &lt;enumeration value="Yards"/>
 *     &lt;enumeration value="Meters"/>
 *     &lt;enumeration value="Fathoms"/>
 *     &lt;enumeration value="Rods"/>
 *     &lt;enumeration value="Chains"/>
 *     &lt;enumeration value="Furlongs"/>
 *     &lt;enumeration value="Cablelengths"/>
 *     &lt;enumeration value="Kilometers"/>
 *     &lt;enumeration value="Miles"/>
 *     &lt;enumeration value="Nauticalmile"/>
 *     &lt;enumeration value="League"/>
 *     &lt;enumeration value="Nauticalleague"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "Lengths")
@XmlEnum
public enum Lengths {

    @XmlEnumValue("Angstroms")
    ANGSTROMS("Angstroms"),
    @XmlEnumValue("Nanometers")
    NANOMETERS("Nanometers"),
    @XmlEnumValue("Microinch")
    MICROINCH("Microinch"),
    @XmlEnumValue("Microns")
    MICRONS("Microns"),
    @XmlEnumValue("Mils")
    MILS("Mils"),
    @XmlEnumValue("Millimeters")
    MILLIMETERS("Millimeters"),
    @XmlEnumValue("Centimeters")
    CENTIMETERS("Centimeters"),
    @XmlEnumValue("Inches")
    INCHES("Inches"),
    @XmlEnumValue("Links")
    LINKS("Links"),
    @XmlEnumValue("Spans")
    SPANS("Spans"),
    @XmlEnumValue("Feet")
    FEET("Feet"),
    @XmlEnumValue("Cubits")
    CUBITS("Cubits"),
    @XmlEnumValue("Varas")
    VARAS("Varas"),
    @XmlEnumValue("Yards")
    YARDS("Yards"),
    @XmlEnumValue("Meters")
    METERS("Meters"),
    @XmlEnumValue("Fathoms")
    FATHOMS("Fathoms"),
    @XmlEnumValue("Rods")
    RODS("Rods"),
    @XmlEnumValue("Chains")
    CHAINS("Chains"),
    @XmlEnumValue("Furlongs")
    FURLONGS("Furlongs"),
    @XmlEnumValue("Cablelengths")
    CABLELENGTHS("Cablelengths"),
    @XmlEnumValue("Kilometers")
    KILOMETERS("Kilometers"),
    @XmlEnumValue("Miles")
    MILES("Miles"),
    @XmlEnumValue("Nauticalmile")
    NAUTICALMILE("Nauticalmile"),
    @XmlEnumValue("League")
    LEAGUE("League"),
    @XmlEnumValue("Nauticalleague")
    NAUTICALLEAGUE("Nauticalleague");
    private final String value;

    Lengths(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Lengths fromValue(String v) {
        for (Lengths c : Lengths.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
