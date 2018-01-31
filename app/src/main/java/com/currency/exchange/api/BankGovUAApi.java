package com.currency.exchange.api;


import com.currency.exchange.api.interfaces.BankGovUAService;
import com.currency.exchange.interfaces.IConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BankGovUAApi implements IConstants {

    private BankGovUAService mService;
    private static BankGovUAApi mInstance;

    private BankGovUAApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANKGOVUA_RATES_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(BankGovUAService.class);
    }

    public static BankGovUAApi getInstance() {
        if (mInstance == null) {
            mInstance = new BankGovUAApi();
        }

        return mInstance;
    }

    public BankGovUAService getService() {
        return mService;
    }
}
