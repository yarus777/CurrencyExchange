package com.currency.exchange.core.uabank;


import com.currency.exchange.core.uabank.response.BankGovUAPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UaBankApi {

    @GET("/NBUStatService/v1/statdirectory/exchange?json")
    Call<List<BankGovUAPostRatesModel>> getBankGovUARates();
}
