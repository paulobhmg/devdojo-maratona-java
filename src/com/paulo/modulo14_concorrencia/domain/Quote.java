package com.paulo.modulo14_concorrencia.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Quote {
    private String product;
    private double price;
    private Discount.Code discount;
    private double calculatedDiscount;

    private Quote(String product, double price, Discount.Code discount) {
        this.product = product;
        this.price = price;
        this.discount = discount;
    }

    public static Quote makeQuote (String pattern) {
        String[] result = pattern.split(":");
        return new Quote(result[0], Double.parseDouble(result[1]), Discount.Code.valueOf(result[2]));
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return String.format("%s, price: %.2f, discount: %s - %d%%, calculated discount: %.2f.",
                    product, price, discount, discount.getCode(), (calculatedDiscount > 0 ? calculatedDiscount : 0)
        );
    }

    public double getCalculatedDiscount() {
        return calculatedDiscount;
    }

    public void setCalculatedDiscount(double calculatedDiscount) {
        this.calculatedDiscount = calculatedDiscount;
    }
}
