package com.currency.exchange.core.cbr;

import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.cbr.response.ValCurs;
import com.currency.exchange.core.cbr.response.ValuteType;

public class CbrResponseConverter {
    public CurrencyRatesModel convert(ValCurs raw) {
        CurrencyRatesModel model = new CurrencyRatesModel();
        for(ValuteType val: raw.getValute()) {
            model.addRate(new CurrencyRate(val.getCharCode(), val.getValue()));
        }
        return model;
    }
}
