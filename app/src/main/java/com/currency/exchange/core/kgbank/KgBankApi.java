package com.currency.exchange.core.kgbank;


import com.currency.exchange.core.kgbank.response.KgBankResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KgBankApi {

    @GET("/XML/weekly.xml")
    Call<KgBankResponseModel> getKgBankWeeklyRates();

    @GET("/XML/daily.xml")
    Call<KgBankResponseModel> getKgBankDailyRates();
}
