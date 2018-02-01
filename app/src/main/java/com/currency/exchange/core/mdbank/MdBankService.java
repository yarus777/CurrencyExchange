package com.currency.exchange.core.mdbank;

import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.cbr.response.ValCurs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MdBankService implements ICurrencyService {

    private String API_URL = "http://www.bnm.md";

    private MdBankApi mApi;
    private MdBankResponseConverter mConverter;
    private String mCurrentDate;

    public MdBankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();
        mApi = retrofit.create(MdBankApi.class);
        mConverter = new MdBankResponseConverter();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        mCurrentDate = dateFormat.format(date);
    }

    public void getRates(final ExchangeRatesReceivedCallback callback) {
        mApi.getMdBankRates(1,mCurrentDate).enqueue(new Callback<ValCurs>() {
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
