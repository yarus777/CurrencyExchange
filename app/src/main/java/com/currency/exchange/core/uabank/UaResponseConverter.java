package com.currency.exchange.core.uabank;

import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.uabank.response.BankGovUAPostRatesModel;

import java.util.List;

public class UaResponseConverter {
    public CurrencyRatesModel convert(List<BankGovUAPostRatesModel> rawData) {
        CurrencyRatesModel response = new CurrencyRatesModel();
        for(BankGovUAPostRatesModel rawRate: rawData){
            response.addRate(new CurrencyRate(rawRate.getCc(), rawRate.getRate()));
        }
        return response;
    }
}
