
package airport.saibot.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the airport.saibot.security package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CancelRequestForAirportAccreditationRequest_QNAME = new QName("saibot.airport/security", "CancelRequestForAirportAccreditationRequest");
    private final static QName _CancelRequestForAirportAccreditationResponse_QNAME = new QName("saibot.airport/security", "CancelRequestForAirportAccreditationResponse");
    private final static QName _RetrieveStatusOfAirportAccreditationRequestRequest_QNAME = new QName("saibot.airport/security", "RetrieveStatusOfAirportAccreditationRequestRequest");
    private final static QName _DecideInternalScreeningLevelInput_QNAME = new QName("saibot.airport/security", "DecideInternalScreeningLevelInput");
    private final static QName _RequestForAirportAccreditationFinalResponse_QNAME = new QName("saibot.airport/security", "RequestForAirportAccreditationFinalResponse");
    private final static QName _DecideInternalScreeningLevelOutput_QNAME = new QName("saibot.airport/security", "DecideInternalScreeningLevelOutput");
    private final static QName _RequestForAirportAccreditationFault_QNAME = new QName("saibot.airport/security", "RequestForAirportAccreditationFault");
    private final static QName _AirportAccreditationProcessState_QNAME = new QName("saibot.airport/security", "AirportAccreditationProcessState");
    private final static QName _RequestForAirportAccreditationRequest_QNAME = new QName("saibot.airport/security", "RequestForAirportAccreditationRequest");
    private final static QName _RequestForAirportAccreditationResponse_QNAME = new QName("saibot.airport/security", "RequestForAirportAccreditationResponse");
    private final static QName _RetrieveStatusOfAirportAccreditationRequestResponse_QNAME = new QName("saibot.airport/security", "RetrieveStatusOfAirportAccreditationRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: airport.saibot.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestForAirportAccreditationRequestType }
     * 
     */
    public RequestForAirportAccreditationRequestType createRequestForAirportAccreditationRequestType() {
        return new RequestForAirportAccreditationRequestType();
    }

    /**
     * Create an instance of {@link RequestForAirportAccreditationFaultType }
     * 
     */
    public RequestForAirportAccreditationFaultType createRequestForAirportAccreditationFaultType() {
        return new RequestForAirportAccreditationFaultType();
    }

    /**
     * Create an instance of {@link DecideInternalScreeningLevelOutputType }
     * 
     */
    public DecideInternalScreeningLevelOutputType createDecideInternalScreeningLevelOutputType() {
        return new DecideInternalScreeningLevelOutputType();
    }

    /**
     * Create an instance of {@link RetrieveStatusOfAirportAccreditationRequestResponseType }
     * 
     */
    public RetrieveStatusOfAirportAccreditationRequestResponseType createRetrieveStatusOfAirportAccreditationRequestResponseType() {
        return new RetrieveStatusOfAirportAccreditationRequestResponseType();
    }

    /**
     * Create an instance of {@link AirportAccreditationProcessStateType }
     * 
     */
    public AirportAccreditationProcessStateType createAirportAccreditationProcessStateType() {
        return new AirportAccreditationProcessStateType();
    }

    /**
     * Create an instance of {@link RequestForAirportAccreditationResponseType }
     * 
     */
    public RequestForAirportAccreditationResponseType createRequestForAirportAccreditationResponseType() {
        return new RequestForAirportAccreditationResponseType();
    }

    /**
     * Create an instance of {@link RetrieveStatusOfAirportAccreditationRequestRequestType }
     * 
     */
    public RetrieveStatusOfAirportAccreditationRequestRequestType createRetrieveStatusOfAirportAccreditationRequestRequestType() {
        return new RetrieveStatusOfAirportAccreditationRequestRequestType();
    }

    /**
     * Create an instance of {@link CancelRequestForAirportAccreditationResponseType }
     * 
     */
    public CancelRequestForAirportAccreditationResponseType createCancelRequestForAirportAccreditationResponseType() {
        return new CancelRequestForAirportAccreditationResponseType();
    }

    /**
     * Create an instance of {@link CancelRequestForAirportAccreditationRequestType }
     * 
     */
    public CancelRequestForAirportAccreditationRequestType createCancelRequestForAirportAccreditationRequestType() {
        return new CancelRequestForAirportAccreditationRequestType();
    }

    /**
     * Create an instance of {@link RequestForAirportAccreditationFinalResponseType }
     * 
     */
    public RequestForAirportAccreditationFinalResponseType createRequestForAirportAccreditationFinalResponseType() {
        return new RequestForAirportAccreditationFinalResponseType();
    }

    /**
     * Create an instance of {@link DecideInternalScreeningLevelInputType }
     * 
     */
    public DecideInternalScreeningLevelInputType createDecideInternalScreeningLevelInputType() {
        return new DecideInternalScreeningLevelInputType();
    }

    /**
     * Create an instance of {@link StaffIdentityDetailsType }
     * 
     */
    public StaffIdentityDetailsType createStaffIdentityDetailsType() {
        return new StaffIdentityDetailsType();
    }

    /**
     * Create an instance of {@link StaffMemberType }
     * 
     */
    public StaffMemberType createStaffMemberType() {
        return new StaffMemberType();
    }

    /**
     * Create an instance of {@link RequestForAirportAccreditationRequestType.StaffReferences }
     * 
     */
    public RequestForAirportAccreditationRequestType.StaffReferences createRequestForAirportAccreditationRequestTypeStaffReferences() {
        return new RequestForAirportAccreditationRequestType.StaffReferences();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequestForAirportAccreditationRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "CancelRequestForAirportAccreditationRequest")
    public JAXBElement<CancelRequestForAirportAccreditationRequestType> createCancelRequestForAirportAccreditationRequest(CancelRequestForAirportAccreditationRequestType value) {
        return new JAXBElement<CancelRequestForAirportAccreditationRequestType>(_CancelRequestForAirportAccreditationRequest_QNAME, CancelRequestForAirportAccreditationRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequestForAirportAccreditationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "CancelRequestForAirportAccreditationResponse")
    public JAXBElement<CancelRequestForAirportAccreditationResponseType> createCancelRequestForAirportAccreditationResponse(CancelRequestForAirportAccreditationResponseType value) {
        return new JAXBElement<CancelRequestForAirportAccreditationResponseType>(_CancelRequestForAirportAccreditationResponse_QNAME, CancelRequestForAirportAccreditationResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveStatusOfAirportAccreditationRequestRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RetrieveStatusOfAirportAccreditationRequestRequest")
    public JAXBElement<RetrieveStatusOfAirportAccreditationRequestRequestType> createRetrieveStatusOfAirportAccreditationRequestRequest(RetrieveStatusOfAirportAccreditationRequestRequestType value) {
        return new JAXBElement<RetrieveStatusOfAirportAccreditationRequestRequestType>(_RetrieveStatusOfAirportAccreditationRequestRequest_QNAME, RetrieveStatusOfAirportAccreditationRequestRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecideInternalScreeningLevelInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "DecideInternalScreeningLevelInput")
    public JAXBElement<DecideInternalScreeningLevelInputType> createDecideInternalScreeningLevelInput(DecideInternalScreeningLevelInputType value) {
        return new JAXBElement<DecideInternalScreeningLevelInputType>(_DecideInternalScreeningLevelInput_QNAME, DecideInternalScreeningLevelInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestForAirportAccreditationFinalResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RequestForAirportAccreditationFinalResponse")
    public JAXBElement<RequestForAirportAccreditationFinalResponseType> createRequestForAirportAccreditationFinalResponse(RequestForAirportAccreditationFinalResponseType value) {
        return new JAXBElement<RequestForAirportAccreditationFinalResponseType>(_RequestForAirportAccreditationFinalResponse_QNAME, RequestForAirportAccreditationFinalResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecideInternalScreeningLevelOutputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "DecideInternalScreeningLevelOutput")
    public JAXBElement<DecideInternalScreeningLevelOutputType> createDecideInternalScreeningLevelOutput(DecideInternalScreeningLevelOutputType value) {
        return new JAXBElement<DecideInternalScreeningLevelOutputType>(_DecideInternalScreeningLevelOutput_QNAME, DecideInternalScreeningLevelOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestForAirportAccreditationFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RequestForAirportAccreditationFault")
    public JAXBElement<RequestForAirportAccreditationFaultType> createRequestForAirportAccreditationFault(RequestForAirportAccreditationFaultType value) {
        return new JAXBElement<RequestForAirportAccreditationFaultType>(_RequestForAirportAccreditationFault_QNAME, RequestForAirportAccreditationFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AirportAccreditationProcessStateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "AirportAccreditationProcessState")
    public JAXBElement<AirportAccreditationProcessStateType> createAirportAccreditationProcessState(AirportAccreditationProcessStateType value) {
        return new JAXBElement<AirportAccreditationProcessStateType>(_AirportAccreditationProcessState_QNAME, AirportAccreditationProcessStateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestForAirportAccreditationRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RequestForAirportAccreditationRequest")
    public JAXBElement<RequestForAirportAccreditationRequestType> createRequestForAirportAccreditationRequest(RequestForAirportAccreditationRequestType value) {
        return new JAXBElement<RequestForAirportAccreditationRequestType>(_RequestForAirportAccreditationRequest_QNAME, RequestForAirportAccreditationRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestForAirportAccreditationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RequestForAirportAccreditationResponse")
    public JAXBElement<RequestForAirportAccreditationResponseType> createRequestForAirportAccreditationResponse(RequestForAirportAccreditationResponseType value) {
        return new JAXBElement<RequestForAirportAccreditationResponseType>(_RequestForAirportAccreditationResponse_QNAME, RequestForAirportAccreditationResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveStatusOfAirportAccreditationRequestResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "saibot.airport/security", name = "RetrieveStatusOfAirportAccreditationRequestResponse")
    public JAXBElement<RetrieveStatusOfAirportAccreditationRequestResponseType> createRetrieveStatusOfAirportAccreditationRequestResponse(RetrieveStatusOfAirportAccreditationRequestResponseType value) {
        return new JAXBElement<RetrieveStatusOfAirportAccreditationRequestResponseType>(_RetrieveStatusOfAirportAccreditationRequestResponse_QNAME, RetrieveStatusOfAirportAccreditationRequestResponseType.class, null, value);
    }

}
