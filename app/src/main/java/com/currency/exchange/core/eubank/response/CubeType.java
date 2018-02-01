package com.currency.exchange.core.eubank.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Cube", strict = false)
public class CubeType {

    @Attribute(name = "currency", required = false)
    private String currency;
    @Attribute(name = "rate", required = false)
    private Double rate;

    public CubeType() {

    }

    public String getCurrency() {
        return currency;
    }

    public Double getRate() {
        return rate;
    }

}
