package com.paulo.modulo15_patterns.domain;

public interface ICurrency {
    String getCurrency();
}

class Real implements ICurrency {
    @Override
    public String getCurrency() {
        return "R$";
    }
}

class Dolar implements ICurrency {
    @Override
    public String getCurrency() {
        return "U$";
    }
}
