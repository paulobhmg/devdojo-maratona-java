package com.paulo.modulo15_patterns.domain;

public class CurrencyFactory {
    public static ICurrency makeCurrency(CountryEnum country) {
        switch (country) {
            case BRAZIL: return new Real();
            case USA: return new Dolar();
            default: throw new IllegalArgumentException("There is not currency for the provided option.");
        }
    }
}
