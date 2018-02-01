
package com.currency.exchange.core.lvbank.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CurrencyType", strict = false)
public class CurrencyType {

    @Element(name = "ID", required = false)
    private String id;
    @Element(name = "Rate", required = false)
    private Double rate;

    public CurrencyType() {
    }

    public String getId() {
        return id;
    }

    public Double getRate() {
        return rate;
    }


}
