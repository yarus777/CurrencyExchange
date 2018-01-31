package com.currency.exchange.core.nbrb;

import com.currency.exchange.core.nbrb.response.NBRBPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NbrbApi {

    @GET("/API/ExRates/Rates")
    Call<List<NBRBPostRatesModel>> getNBRBRates(@Query("Periodicity") int periodicity);

}
