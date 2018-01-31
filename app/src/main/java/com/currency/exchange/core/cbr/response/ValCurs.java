
package com.currency.exchange.core.cbr.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "ValCurs", strict = false)
//@Namespace(reference = "")
public class ValCurs {

    @ElementList(name = "Valute", entry = "Valute", inline = true, required = false)
    private List<ValuteType> valute;
    @Attribute(name = "Date", required = false)
    private String date;
    @Attribute(name = "name", required = false)
    private String name;

    public ValCurs() {
    }

    public List<ValuteType> getValute() {
        return valute;
    }

    public void setValute(List<ValuteType> valute) {
        this.valute = valute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
