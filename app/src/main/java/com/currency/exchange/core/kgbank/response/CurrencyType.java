package com.currency.exchange.core.kgbank.response;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Root(name = "Currency", strict = false)
public class CurrencyType {

    @Attribute(name = "ISOCode", required = false)
    private String isoCode;
    @Element(name = "Nominal", required = false)
    private Integer nominal;
    @Element(name = "ValidFor", required = false)
    private Integer validFor;
    @Element(name = "Value", required = false)
    private String value;

    private NumberFormat mFormat;

    public CurrencyType() {
        mFormat = NumberFormat.getInstance(Locale.FRANCE);
    }

    public String getIsoCode() {
        return isoCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public Integer getValidFor() {
        return validFor;
    }

    public Double getValue() {
        try {
            return mFormat.parse(value).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1d;
        }
    }
}
