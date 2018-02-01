package com.currency.exchange.core.plbank;


import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.plbank.response.PlBankPostRatesModel;
import com.currency.exchange.core.plbank.response.Rate;

import java.util.List;


public class PlBankResponseConverter {

    public CurrencyRatesModel convert(List<PlBankPostRatesModel> models) {
        CurrencyRatesModel model = new CurrencyRatesModel();
        for (PlBankPostRatesModel rates : models) {
            for (Rate rate : rates.getRates()) {
                model.addRate(new CurrencyRate(rate.getCode(), rate.getMid()));
            }
        }

        return model;
    }
}
