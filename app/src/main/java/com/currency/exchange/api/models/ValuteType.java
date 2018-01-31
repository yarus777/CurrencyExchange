
package com.currency.exchange.api.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

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
    private Double value;
    @Attribute(name = "ID", required = false)
    private String id;
    

    public ValuteType() {
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
