package com.currency.exchange.core.eubank.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Cube", strict = false)
public class CubesType {

    @Attribute(name = "time", required = false)
    private String time;
    @ElementList(name = "Cube", entry = "Cube", inline = true, required = false)
    private List<CubeType> cube;

    public CubesType() {

    }

    public String getTime() {
        return time;
    }

    public List<CubeType> getCubeType() {
        return cube;
    }

}
