package org.example;

import lombok.Data;

@Data

public class ExchangeResponse {

    private String src;

    private String dest;

    private double exchangeRate;

    private double principleAmount;

    private double ConverteAmount;

}
