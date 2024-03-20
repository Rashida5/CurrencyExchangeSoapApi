package org.example;

import jakarta.jws.WebService;
import org.example.client.Disclaimer;
import org.example.client.ExchangeRateService;
import org.example.client.ExchangeRateServiceImplService;

@WebService(endpointInterface = "org.example.ExchangeCalculatorService")
public class ExchangeCalculatorServiceImpl implements ExchangeCalculatorService{
    @Override
    public double calculateExchange(ExchangeRequest request) {
        ExchangeRateServiceImplService exchangeRateService = new ExchangeRateServiceImplService();
        ExchangeRateService exchangeRateService1 = exchangeRateService.getExchangeRateServiceImplPort();
        double rate = exchangeRateService1.getExchangeRate(request.getSourceCountry(),request.getDestinationCountry(), Disclaimer.DOM);
        return rate*request.getAmount();

    }
}
