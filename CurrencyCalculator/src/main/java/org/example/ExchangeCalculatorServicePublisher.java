package org.example;

import jakarta.xml.ws.Endpoint;

public class ExchangeCalculatorServicePublisher {

    public static void main(String[] args) {
        String address = "http://localhost:8082/ExchangeWebService";

        ExchangeCalculatorService calculatorWebService = new ExchangeCalculatorServiceImpl();


        Endpoint.publish(address, calculatorWebService);

        System.out.println("CalculatorWebService published at: "+address);
    }
}
