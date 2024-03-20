package org.example;

import jakarta.xml.ws.Endpoint;

public class ExchangeRateServicePublisher {

    public static void main(String args[]){
        String address = "http://localhost:8081/CurrencyWebService";

        ExchangeRateService calculatorWebService = new ExchangeRateServiceImpl();

        Endpoint.publish(address, calculatorWebService);

        System.out.println("CalculatorWebService published at: "+address);
    }
}
