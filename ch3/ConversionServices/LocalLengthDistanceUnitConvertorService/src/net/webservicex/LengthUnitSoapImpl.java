package net.webservicex;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "lengthUnitSoap", targetNamespace = "http://www.webserviceX.NET/", serviceName = "lengthUnit",
            portName = "lengthUnitSoap", wsdlLocation = "/WEB-INF/wsdl/lengthUnit.wsdl")
@XmlSeeAlso({ ObjectFactory.class })
public class LengthUnitSoapImpl {
    public LengthUnitSoapImpl() {
    }

    @RequestWrapper(localName = "ChangeLengthUnit", targetNamespace = "http://www.webserviceX.NET/",
                    className = "net.webservicex.ChangeLengthUnit")
    @ResponseWrapper(localName = "ChangeLengthUnitResponse", targetNamespace = "http://www.webserviceX.NET/",
                     className = "net.webservicex.ChangeLengthUnitResponse")
    @WebMethod(operationName = "ChangeLengthUnit", action = "http://www.webserviceX.NET/ChangeLengthUnit")
    @WebResult(name = "ChangeLengthUnitResult", targetNamespace = "http://www.webserviceX.NET/")
    public double changeLengthUnit(@WebParam(name = "LengthValue", targetNamespace = "http://www.webserviceX.NET/")
                                   double lengthValue,
                                   @WebParam(name = "fromLengthUnit", targetNamespace = "http://www.webserviceX.NET/")
                                   Lengths fromLengthUnit,
                                   @WebParam(name = "toLengthUnit", targetNamespace = "http://www.webserviceX.NET/")
                                   Lengths toLengthUnit) {
        return 0;
    }
}
