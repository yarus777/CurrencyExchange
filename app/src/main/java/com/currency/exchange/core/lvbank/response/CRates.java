
package com.currency.exchange.core.lvbank.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CRates", strict = false)
public class CRates {

    @Element(name = "Date", required = false)
    private Integer date;
    @Element(name = "Currencies", required = false)
    private CurrenciesType currencies;
    @Attribute(name = "dc:source", required = false)
    private String dcSource;
    @Attribute(name = "xsi:schemaLocation", required = false)
    private String xsiSchemaLocation;
    @Attribute(name = "dc:description", required = false)
    private String dcDescription;

    public CRates() {
    }

    public Integer getDate() {
        return date;
    }


    public CurrenciesType getCurrencies() {
        return currencies;
    }


    public String getDcSource() {
        return dcSource;
    }


    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }


    public String getDcDescription() {
        return dcDescription;
    }


}
