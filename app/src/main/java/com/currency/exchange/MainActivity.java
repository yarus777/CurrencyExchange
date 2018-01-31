package com.currency.exchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.currency.exchange.adapters.CurrencyRatesRecyclerViewAdapter;
import com.currency.exchange.api.CBRApi;
import com.currency.exchange.api.models.BankGovUAPostRatesModel;
import com.currency.exchange.api.models.NBRBPostRatesModel;
import com.currency.exchange.api.models.ValCurs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CurrencyRatesRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<NBRBPostRatesModel> mList;
    private List<BankGovUAPostRatesModel> mList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.currency_recycle_view);
        mList = new ArrayList<>();
        mList1 = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

       CBRApi.getInstance().getService().getCBRRates().enqueue(new Callback<List<ValCurs>>() {
            @Override
            public void onResponse(Call<List<ValCurs>> call, Response<List<ValCurs>> response) {
                //mList1.addAll(response.body());
                //mAdapter = new CurrencyRatesRecyclerViewAdapter(mList1);
                //mRecyclerView.setAdapter(mAdapter);
                //mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ValCurs>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        /*BankGovUAApi.getInstance().getService().getBankGovUARates().enqueue(new Callback<List<BankGovUAPostRatesModel>>() {
            @Override
            public void onResponse(Call<List<BankGovUAPostRatesModel>> call, Response<List<BankGovUAPostRatesModel>> response) {
                mList1.addAll(response.body());
                mAdapter = new CurrencyRatesRecyclerViewAdapter(mList1);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<BankGovUAPostRatesModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });*/


        /*NBRBApi.getInstance().getService().getNBRBRates(0).enqueue(new Callback<List<NBRBPostRatesModel>>() {
            @Override
            public void onResponse(Call<List<NBRBPostRatesModel>> call, Response<List<NBRBPostRatesModel>> response) {
                mList.addAll(response.body());
                mAdapter = new CurrencyRatesRecyclerViewAdapter(mList);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NBRBPostRatesModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
