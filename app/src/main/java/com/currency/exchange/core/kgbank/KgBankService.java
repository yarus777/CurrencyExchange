package com.currency.exchange.core.kgbank;


import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.kgbank.response.KgBankResponseModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class KgBankService implements ICurrencyService {

    private String API_URL = "http://www.nbkr.kg/";

    private KgBankApi mApi;
    private KgBankResponseConverter mConverter;

    public KgBankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();
        mApi = retrofit.create(KgBankApi.class);
        mConverter = new KgBankResponseConverter();
    }

    public void getRates(final ExchangeRatesReceivedCallback callback) {
        final List<KgBankResponseModel> mList = new ArrayList<>();
        mApi.getKgBankWeeklyRates().enqueue(new Callback<KgBankResponseModel>() {
            @Override
            public void onResponse(Call<KgBankResponseModel> call, Response<KgBankResponseModel> response) {
                mList.add(response.body());
                mApi.getKgBankDailyRates().enqueue(new Callback<KgBankResponseModel>() {
                    @Override
                    public void onResponse(Call<KgBankResponseModel> call, Response<KgBankResponseModel> response) {
                        mList.add(response.body());
                        callback.onSuccess(mConverter.convert(mList));
                    }

                    @Override
                    public void onFailure(Call<KgBankResponseModel> call, Throwable t) {
                        callback.onError(t);
                    }
                });
            }

            @Override
            public void onFailure(Call<KgBankResponseModel> call, Throwable t) {
                callback.onError(t);
            }
        });

    }
}
