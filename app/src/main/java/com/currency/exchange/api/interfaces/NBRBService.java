package com.currency.exchange.api.interfaces;


import com.currency.exchange.api.models.NBRBPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NBRBService {

    @GET("/API/ExRates/Rates")
    Call<List<NBRBPostRatesModel>> getNBRBRates(@Query("Periodicity") int periodicity);

}
