package com.currency.exchange.core.eubank;

import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.eubank.response.EuBankResponseModel;

public class EuBankResponseConverter {
    public CurrencyRatesModel convert(EuBankResponseModel raw) {
        CurrencyRatesModel model = new CurrencyRatesModel();
        /*for(ValuteType val: raw.getValute()) {
            model.addRate(new CurrencyRate(val.getCharCode(), val.getValue()));
        }*/
        return model;
    }
}
