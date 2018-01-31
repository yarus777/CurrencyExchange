package com.currency.exchange.api.interfaces;


import com.currency.exchange.api.models.BankGovUAPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BankGovUAService {

    @GET("/NBUStatService/v1/statdirectory/exchange?json")
    Call<List<BankGovUAPostRatesModel>> getBankGovUARates();
}
