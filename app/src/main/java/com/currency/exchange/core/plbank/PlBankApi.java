package com.currency.exchange.core.plbank;


import com.currency.exchange.core.plbank.response.PlBankPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlBankApi {

    @GET("/api/exchangerates/tables/a?format=json")
    Call<List<PlBankPostRatesModel>> getPlBankRates();
}
