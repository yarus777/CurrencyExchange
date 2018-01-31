package com.currency.exchange.core;

public class CurrencyRate {
    private String mAbbreviation;
    private double mRate;

    public CurrencyRate(String mAbbreviation, double mRate) {
        this.mAbbreviation = mAbbreviation;
        this.mRate = mRate;
    }

    public String getAbbreviation() {
        return mAbbreviation;
    }

    public double getRate() {
        return mRate;
    }
}
