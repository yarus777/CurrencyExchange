package com.currency.exchange.core.nbrb;

import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.nbrb.response.NBRBPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NbrbService implements ICurrencyService {
    private String API_URL = "http://www.nbrb.by/";

    private NbrbApi mApi;
    private NbrbResponseConverter mConverter;

    public NbrbService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(NbrbApi.class);
        mConverter = new NbrbResponseConverter();
    }

    @Override
    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getNBRBRates(0).enqueue(new Callback<List<NBRBPostRatesModel>>() {
            @Override
            public void onResponse(Call<List<NBRBPostRatesModel>> call, Response<List<NBRBPostRatesModel>> response) {
                if(response.isSuccessful()) {
                    callback.onSuccess(mConverter.convert(response.body()));
                } else {
                    onFailure(call, new Exception(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<NBRBPostRatesModel>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
