package com.currency.exchange.core.plbank;


import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.plbank.response.PlBankPostRatesModel;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlBankService implements ICurrencyService {

    private String API_URL = "http://api.nbp.pl/";

    private PlBankApi mApi;
    private PlBankResponseConverter mConverter;

    public PlBankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(PlBankApi.class);
        mConverter = new PlBankResponseConverter();
    }
    @Override
    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getPlBankRates().enqueue(new Callback<List<PlBankPostRatesModel>>() {
            @Override
            public void onResponse(Call<List<PlBankPostRatesModel>> call, Response<List<PlBankPostRatesModel>> response) {
                callback.onSuccess(mConverter.convert(response.body()));
            }

            @Override
            public void onFailure(Call<List<PlBankPostRatesModel>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
