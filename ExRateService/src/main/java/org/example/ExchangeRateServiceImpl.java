package org.example;

import jakarta.jws.WebService;
import org.example.Exceptions.ParserException;
import org.example.enums.Disclaimer;
import org.example.parser.DOMParser;
import org.example.parser.XPathParser;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;


@WebService(endpointInterface = "org.example.ExchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService{

    @Override
    public double getExchangeRate(String source, String destination, String disclaimer) throws ParserException {
        double rate = 0;


            if (disclaimer.equals("DOM")) {
                rate = getExchangeRateDOM(source, destination);
            } else if (disclaimer.equals("XPath")) {
                rate = getExchangeRateXpath(source, destination);
            }
            else{
                throw new ParserException("Error Parsing type","ER001");
            }


       return rate;
    }

    @Override
    public double getExchangeRateDOM(String source, String destination) {
        double rate ;
        try {
            File file = new File("C:\\Users\\Rashida\\Desktop\\Labs\\SOAP\\CurrencyExchangeSoapApi\\ExRateService\\src\\main\\resources\\exchange_rates.xml");
            FileInputStream inputStream = new FileInputStream(file);
            rate=DOMParser.getExchangeRate(inputStream, source, destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return rate;
    }

    @Override
    public double getExchangeRateXpath(String source, String destination) {
        double rate ;
        try {
            File file = new File("C:\\Users\\Rashida\\Desktop\\Labs\\SOAP\\CurrencyExchangeSoapApi\\ExRateService\\src\\main\\resources\\exchange_rates.xml");
            FileInputStream inputStream = new FileInputStream(file);
            rate= XPathParser.getExchangeRate(inputStream, source, destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rate;
    }
}
