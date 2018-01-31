
package com.currency.exchange.core.cbr.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Root(name = "ValuteType", strict = false)
//@Namespace(reference = "")
public class ValuteType {

    @Element(name = "NumCode", required = false)
    private Integer numCode;
    @Element(name = "CharCode", required = false)
    private String charCode;
    @Element(name = "Nominal", required = false)
    private Integer nominal;
    @Element(name = "Name", required = false)
    private String name;
    @Element(name = "Value", required = false)
    private String value;
    @Attribute(name = "ID", required = false)
    private String id;

    private NumberFormat mFormat;

    public ValuteType() {
        mFormat = NumberFormat.getInstance(Locale.FRANCE);
    }

    public Integer getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        try {
            return mFormat.parse(value).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1d;
        }
    }

    public String getId() {
        return id;
    }

}
