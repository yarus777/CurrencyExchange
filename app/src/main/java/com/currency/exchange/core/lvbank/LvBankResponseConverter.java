package com.currency.exchange.core.lvbank;


import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.lvbank.response.CRates;
import com.currency.exchange.core.lvbank.response.CurrencyType;

public class LvBankResponseConverter {

    public CurrencyRatesModel convert(CRates rates) {
        CurrencyRatesModel model = new CurrencyRatesModel();
        for (CurrencyType curr : rates.getCurrencies().getCurrency()) {
            model.addRate(new CurrencyRate(curr.getId(), curr.getRate()));
        }
        return model;
    }
}
