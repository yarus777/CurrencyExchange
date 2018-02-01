package com.currency.exchange.core.lvbank;


import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.lvbank.response.CRates;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class LvBankService implements ICurrencyService {

    private String API_URL = "https://www.bank.lv/";

    private LvBankApi mApi;
    private LvBankResponseConverter mConverter;

    public LvBankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();
        mApi = retrofit.create(LvBankApi.class);
        mConverter = new LvBankResponseConverter();
    }

    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getLvBankRates().enqueue(new Callback<CRates>() {
            @Override
            public void onResponse(Call<CRates> call, Response<CRates> response) {
                callback.onSuccess(mConverter.convert(response.body()));
            }

            @Override
            public void onFailure(Call<CRates> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
