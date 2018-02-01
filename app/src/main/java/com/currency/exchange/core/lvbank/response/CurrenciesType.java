
package com.currency.exchange.core.lvbank.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "CurrenciesType", strict = false)
public class CurrenciesType {

    @ElementList(name = "Currency", entry = "Currency", inline = true, required = false)
    private List<CurrencyType> currency;

    public CurrenciesType() {
    }

    public List<CurrencyType> getCurrency() {
        return currency;
    }


}
