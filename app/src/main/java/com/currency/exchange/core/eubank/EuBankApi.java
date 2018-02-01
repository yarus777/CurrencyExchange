package com.currency.exchange.core.eubank;


import com.currency.exchange.core.eubank.response.EuBankResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EuBankApi {

    @GET("/stats/eurofxref/eurofxref-daily.xml")
    Call<EuBankResponseModel> getEuBankRates();


}
