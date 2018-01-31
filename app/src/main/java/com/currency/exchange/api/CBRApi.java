package com.currency.exchange.api;


import com.currency.exchange.api.interfaces.CBRService;
import com.currency.exchange.interfaces.IConstants;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CBRApi implements IConstants {

    private CBRService mService;
    private static CBRApi mInstance;

    private CBRApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CBR_RATES_URL)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
                .build();
        mService = retrofit.create(CBRService.class);
    }

    public static CBRApi getInstance() {
        if (mInstance == null) {
            mInstance = new CBRApi();
        }

        return mInstance;
    }

    public CBRService getService() {
        return mService;
    }
}
