package org.example;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.enums.Disclaimer;

@WebService
public interface ExchangeRateService {


    @WebMethod
    public double getExchangeRate(String source, String destination, Disclaimer disclaimer);

    @WebMethod
    public  double getExchangeRateDOM(String source, String destination);

    @WebMethod
    public double getExchangeRateXpath(String source, String destination);



}
