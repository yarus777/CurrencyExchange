package com.currency.exchange.core.mdbank;


import com.currency.exchange.core.cbr.response.ValCurs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MdBankApi {

    @GET("/ro/official_exchange_rates")
    Call<ValCurs> getMdBankRates(@Query("get_xml") int get_xml, @Query("date") String date);
}
