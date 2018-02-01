package com.currency.exchange.core.eubank;

import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.eubank.response.EuBankResponseModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class EuBankService implements ICurrencyService {

    private String API_URL = "https://www.ecb.europa.eu/";
    //private String API_URL = "http://api.fixer.io/";


    private EuBankApi mApi;
    private EuBankResponseConverter mConverter;

    public EuBankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();
        mApi = retrofit.create(EuBankApi.class);
        mConverter = new EuBankResponseConverter();
    }

    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getEuBankRates().enqueue(new Callback<EuBankResponseModel>() {
            @Override
            public void onResponse(Call<EuBankResponseModel> call, Response<EuBankResponseModel> response) {
                callback.onSuccess(mConverter.convert(response.body()));
            }

            @Override
            public void onFailure(Call<EuBankResponseModel> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
