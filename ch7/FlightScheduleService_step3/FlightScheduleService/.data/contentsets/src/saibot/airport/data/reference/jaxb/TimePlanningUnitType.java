
package saibot.airport.data.reference.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for timePlanningUnitType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="timePlanningUnitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DaysOfWeek" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="day" type="{saibot.airport/data/common}weekDayType" maxOccurs="7" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HourOfDay" type="{saibot.airport/data/common}hourOfDayType" minOccurs="0"/>
 *         &lt;element name="FiveMinuteBlock" type="{saibot.airport/data/common}fiveMinuteBlockType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timePlanningUnitType", propOrder = {
         "startDate", "endDate", "daysOfWeek", "hourOfDay", "fiveMinuteBlock" })
public class TimePlanningUnitType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElementRef(name = "endDate", namespace = "saibot.airport/data/reference", type = JAXBElement.class,
                   required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    @XmlElement(name = "DaysOfWeek")
    protected TimePlanningUnitType.DaysOfWeek daysOfWeek;
    @XmlElement(name = "HourOfDay")
    @XmlSchemaType(name = "integer")
    protected Integer hourOfDay;
    @XmlElement(name = "FiveMinuteBlock")
    @XmlSchemaType(name = "integer")
    protected Integer fiveMinuteBlock;

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the daysOfWeek property.
     *
     * @return
     *     possible object is
     *     {@link TimePlanningUnitType.DaysOfWeek }
     *
     */
    public TimePlanningUnitType.DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Sets the value of the daysOfWeek property.
     *
     * @param value
     *     allowed object is
     *     {@link TimePlanningUnitType.DaysOfWeek }
     *
     */
    public void setDaysOfWeek(TimePlanningUnitType.DaysOfWeek value) {
        this.daysOfWeek = value;
    }

    /**
     * Gets the value of the hourOfDay property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getHourOfDay() {
        return hourOfDay;
    }

    /**
     * Sets the value of the hourOfDay property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setHourOfDay(Integer value) {
        this.hourOfDay = value;
    }

    /**
     * Gets the value of the fiveMinuteBlock property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getFiveMinuteBlock() {
        return fiveMinuteBlock;
    }

    /**
     * Sets the value of the fiveMinuteBlock property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setFiveMinuteBlock(Integer value) {
        this.fiveMinuteBlock = value;
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
     *         &lt;element name="day" type="{saibot.airport/data/common}weekDayType" maxOccurs="7" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "day" })
    public static class DaysOfWeek {

        @XmlSchemaType(name = "string")
        protected List<WeekDayType> day;

        /**
         * Gets the value of the day property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the day property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDay().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WeekDayType }
         *
         *
         */
        public List<WeekDayType> getDay() {
            if (day == null) {
                day = new ArrayList<WeekDayType>();
            }
            return this.day;
        }

    }

}
