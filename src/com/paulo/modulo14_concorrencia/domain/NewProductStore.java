package com.paulo.modulo14_concorrencia.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class NewProductStore {

    public String getPriceSync(String store) {
        double price = getPrice();
        Discount.Code code = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", store, price, code);
    }

    public String getDiscount(Quote quote) {
        delay();
        double price = quote.getPrice();
        double discount = price - (price * (100 - quote.getDiscount().getCode()) / 100);
        quote.setCalculatedDiscount(discount);
        return quote.toString();
    }

    public double getPrice() {
        delay();
        return ThreadLocalRandom.current().nextDouble(1, 500) * 10;
    }

    public void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void newDelay() {
        try {
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getPriceSyncWithNewDelay(String store) {
        double price = getPrice();
        Discount.Code code = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", store, price, code);
    }

    public String getDiscountWithNewDelay(Quote quote) {
        newDelay();
        double price = quote.getPrice();
        double discount = price - (price * (100 - quote.getDiscount().getCode()) / 100);
        quote.setCalculatedDiscount(discount);
        return quote.toString();
    }

    public double getPriceWithNewDelay() {
        newDelay();
        return ThreadLocalRandom.current().nextDouble(1, 500) * 10;
    }
}
