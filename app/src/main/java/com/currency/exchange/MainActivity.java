package com.currency.exchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.currency.exchange.adapters.CurrencyRatesRecyclerViewAdapter;
import com.currency.exchange.core.CurrencyRatesModel;
import com.currency.exchange.core.ExchangeRatesReceivedCallback;
import com.currency.exchange.core.ICurrencyService;
import com.currency.exchange.core.CurrencyServiceType;
import com.currency.exchange.core.cbr.CbrService;
import com.currency.exchange.core.nbrb.NbrbService;
import com.currency.exchange.core.uabank.UaBankService;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private CurrencyRatesRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private CurrencyRatesModel mRates;

    private ExchangeRatesReceivedCallback receivedCallback;

    private Map<CurrencyServiceType, ICurrencyService> mServices = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.currency_recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        initServices();

        receivedCallback = new ExchangeRatesReceivedCallback() {
            @Override
            public void onSuccess(CurrencyRatesModel rates) {
                mRates = rates;
                mAdapter = new CurrencyRatesRecyclerViewAdapter(mRates.getRates());
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void initServices() {
        mServices.put(CurrencyServiceType.Cbr, new CbrService());
        mServices.put(CurrencyServiceType.NbRb, new NbrbService());
        mServices.put(CurrencyServiceType.UaBank, new UaBankService());
    }

    public void loadCbr(View view) {
        mServices.get(CurrencyServiceType.Cbr).getRates(receivedCallback);
    }

    public void loadNbrb(View view) {
        mServices.get(CurrencyServiceType.NbRb).getRates(receivedCallback);
    }

    public void loadUaBank(View view) {
        mServices.get(CurrencyServiceType.UaBank).getRates(receivedCallback);
    }
}
