package com.currency.exchange.core.kgbank.response;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "CurrencyRates", strict = false)
public class KgBankResponseModel {

    @Attribute(name = "Name", required = false)
    private String name;
    @Attribute(name = "Date", required = false)
    private String date;
    @ElementList(name = "Currency", entry = "Currency", inline = true, required = false)
    private List<CurrencyType> currencyType;

    public KgBankResponseModel() {

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<CurrencyType> getCurrencyType() {
        return currencyType;
    }
}
