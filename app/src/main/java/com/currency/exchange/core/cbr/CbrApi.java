package com.currency.exchange.core.cbr;


import com.currency.exchange.core.cbr.response.ValCurs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CbrApi {

    @GET("/scripts/XML_daily.asp")
    Call<ValCurs> getCBRRates();
}
