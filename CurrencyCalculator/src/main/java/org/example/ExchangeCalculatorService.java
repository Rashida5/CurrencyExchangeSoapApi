package org.example;


import jakarta.jws.WebService;

@WebService
public interface ExchangeCalculatorService {

    public double calculateExchange(ExchangeRequest request);
}
