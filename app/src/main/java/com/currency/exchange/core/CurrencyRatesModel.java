package com.currency.exchange.core;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRatesModel {
    private List<CurrencyRate> mRates;

    public CurrencyRatesModel() {
        mRates = new ArrayList<>();
    }

    public List<CurrencyRate> getRates() {
        return mRates;
    }

    public void addRate(CurrencyRate rate) {
        mRates.add(rate);
    }
}
