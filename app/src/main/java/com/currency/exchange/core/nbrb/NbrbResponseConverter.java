package com.currency.exchange.core.nbrb;

import com.currency.exchange.core.CurrencyRate;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.nbrb.response.NBRBPostRatesModel;

import java.util.List;

public class NbrbResponseConverter {
    public CurrencyRatesModel convert(List<NBRBPostRatesModel> rawData) {
        CurrencyRatesModel response = new CurrencyRatesModel();
        for(NBRBPostRatesModel rawRate: rawData){
            response.addRate(new CurrencyRate(rawRate.getCurAbbreviation(), rawRate.getCurOfficialRate()));
        }
        return response;
    }
}
