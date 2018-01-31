package com.currency.exchange.core.cbr;

import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.cbr.response.ValCurs;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CbrService implements ICurrencyService {

    private String API_URL = "http://www.cbr.ru/";

    private CbrApi mApi;
    private ResponseConverter mConverter;

    public CbrService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();
        mApi = retrofit.create(CbrApi.class);
        mConverter = new ResponseConverter();
    }

    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getCBRRates().enqueue(new Callback<ValCurs>() {
            @Override
            public void onResponse(Call<ValCurs> call, Response<ValCurs> response) {
                callback.onSuccess(mConverter.convert(response.body()));
            }

            @Override
            public void onFailure(Call<ValCurs> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
