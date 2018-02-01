package com.currency.exchange.core.lvbank;


import com.currency.exchange.core.lvbank.response.CRates;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LvBankApi {

    @GET("/vk/ecb.xml")
    Call<CRates> getLvBankRates();
}
