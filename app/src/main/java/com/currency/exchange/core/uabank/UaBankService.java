package com.currency.exchange.core.uabank;

import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.uabank.response.BankGovUAPostRatesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UaBankService implements ICurrencyService {
    private String API_URL = "https://bank.gov.ua/";
    private UaBankApi mApi;
    private UaResponseConverter mConverter;

    public UaBankService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(UaBankApi.class);
        mConverter = new UaResponseConverter();
    }

    @Override
    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getBankGovUARates().enqueue(new Callback<List<BankGovUAPostRatesModel>>() {
            @Override
            public void onResponse(Call<List<BankGovUAPostRatesModel>> call, Response<List<BankGovUAPostRatesModel>> response) {
                callback.onSuccess(mConverter.convert(response.body()));
            }

            @Override
            public void onFailure(Call<List<BankGovUAPostRatesModel>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
