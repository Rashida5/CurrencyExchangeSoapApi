package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRequest {

    private String sourceCountry;
    private String destinationCountry;

    private double amount;

}
