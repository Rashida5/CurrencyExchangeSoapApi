package org.example;

import jakarta.jws.WebService;
//import org.example.client.Disclaimer;
import org.example.client.ExchangeRateService;
import org.example.client.ExchangeRateServiceImplService;
import org.example.client.ParserException_Exception;

@WebService(endpointInterface = "org.example.ExchangeCalculatorService")
public class ExchangeCalculatorServiceImpl implements ExchangeCalculatorService{
    @Override
    public ExchangeResponse calculateExchange(ExchangeRequest request, String Disclaimer)  {
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        ExchangeRateServiceImplService exchangeRateService = new ExchangeRateServiceImplService();
        ExchangeRateService exchangeRateService1 = exchangeRateService.getExchangeRateServiceImplPort();
        double rate = 0;
        try {
            rate = exchangeRateService1.getExchangeRate(request.getSourceCountry(),request.getDestinationCountry(), Disclaimer);

        } catch (ParserException_Exception e) {
            throw new RuntimeException(e);
        }
        exchangeResponse.setExchangeRate(rate);
        exchangeResponse.setSrc(request.getSourceCountry());
        exchangeResponse.setDest(request.getDestinationCountry());
        exchangeResponse.setPrincipleAmount(request.getAmount());
        exchangeResponse.setConverteAmount(rate* request.getAmount());
     return exchangeResponse;

    }
}
