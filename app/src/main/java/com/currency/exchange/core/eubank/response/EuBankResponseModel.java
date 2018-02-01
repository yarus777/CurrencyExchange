package com.currency.exchange.core.eubank.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "Envelope", strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.gesmes.org/xml/2002-08-01", prefix = "gesmes"),
        @Namespace(reference = "uhttp://www.ecb.int/vocabulary/2002-08-01/eurofxref")
})

public class EuBankResponseModel {

    @Element(name = "subject", required = false)
    @Namespace(prefix = "gesmes", reference = "http://www.gesmes.org/xml/2002-08-01")
    private String subject;
    @Element(name = "Sender", required = false)
    @Namespace(prefix = "gesmes", reference = "http://www.gesmes.org/xml/2002-08-01")
    private SenderType sender;
    @Element(name = "Cube", required = false)
    private CubesType cube;

    public EuBankResponseModel() {

    }

    public String getSubject() {
        return subject;
    }

    public SenderType getSender() {
        return sender;
    }

    public CubesType getCubesType() {
        return cube;
    }
}
