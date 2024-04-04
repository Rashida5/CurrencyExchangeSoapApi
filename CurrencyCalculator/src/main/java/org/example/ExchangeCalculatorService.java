package org.example;


import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;
import org.example.client.ParserException_Exception;

@WebService(name = "CalculatorWebService",
        portName = "CalculatorWebServicePort",
        serviceName = "CalculatorServiceName",
        targetNamespace = "http://server.services.web.jets.iti.gov.eg/"
)
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public interface ExchangeCalculatorService {

    public ExchangeResponse calculateExchange(ExchangeRequest request,
                                    @WebParam( header = true)String Disclaimer) throws ParserException_Exception;
}
