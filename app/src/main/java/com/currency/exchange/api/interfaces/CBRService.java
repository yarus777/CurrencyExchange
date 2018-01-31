package com.currency.exchange.api.interfaces;


import com.currency.exchange.api.models.ValCurs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CBRService {

    @GET("/scripts/XML_daily.asp")
    Call<List<ValCurs>> getCBRRates();
}
