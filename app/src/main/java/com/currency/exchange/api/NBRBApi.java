package com.currency.exchange.api;


import com.currency.exchange.api.interfaces.NBRBService;
import com.currency.exchange.interfaces.IConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NBRBApi implements IConstants{

    private NBRBService mService;
    private static NBRBApi mInstance;

    private NBRBApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NBRB_RATES_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(NBRBService.class);
    }

    public static NBRBApi getInstance() {
        if (mInstance == null) {
            mInstance = new NBRBApi();
        }

        return mInstance;
    }

    public NBRBService getService() {
        return mService;
    }
}
