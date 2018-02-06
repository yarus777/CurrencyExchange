package com.currency.exchange.core.kgbank;


import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.kgbank.response.CurrencyType;
import com.currency.exchange.core.kgbank.response.KgBankResponseModel;

import java.util.List;

public class KgBankResponseConverter {

    public CurrencyRatesModel convert(List<KgBankResponseModel> rates) {
        CurrencyRatesModel model = new CurrencyRatesModel();
        for (KgBankResponseModel currModel : rates) {
            for (CurrencyType curr : currModel.getCurrencyType()) {
                model.addRate(new CurrencyRate(curr.getIsoCode(), curr.getValue()));
            }
        }
        return model;
    }
}
