package com.currency.exchange.core.eubank.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Sender", strict = false)
@Namespace(prefix = "gesmes", reference = "http://www.gesmes.org/xml/2002-08-01")
public class SenderType {

    @Element(name = "name", required = false)
    @Namespace(prefix = "gesmes", reference = "http://www.gesmes.org/xml/2002-08-01")
    private String name;

    public SenderType() {

    }

    public String getName() {
        return name;
    }
}
