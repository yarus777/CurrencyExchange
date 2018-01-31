package com.currency.exchange.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.currency.exchange.R;
import com.currency.exchange.api.models.BankGovUAPostRatesModel;

import java.util.List;

public class CurrencyRatesRecyclerViewAdapter extends RecyclerView.Adapter<CurrencyRatesRecyclerViewAdapter.CurrencyRatesItem> {

    //private List<NBRBPostRatesModel> mList;
    private List<BankGovUAPostRatesModel> mList;

    public CurrencyRatesRecyclerViewAdapter(List<BankGovUAPostRatesModel> mList/*List<NBRBPostRatesModel> mList*/) {
        this.mList = mList;
    }

    @Override
    public CurrencyRatesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_rates_item, parent, false);
        return new CurrencyRatesItem(v);
    }

    @Override
    public void onBindViewHolder(CurrencyRatesItem holder, int position) {
        holder.mCurrencyName.setText(mList.get(position).getCc());
        holder.mCurrencyRate.setText("" + mList.get(position).getRate());
        //holder.mCurrencyName.setText(mList.get(position).getCurAbbreviation());
        //holder.mCurrencyRate.setText("" + mList.get(position).getCurOfficialRate());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class CurrencyRatesItem extends RecyclerView.ViewHolder {

        TextView mCurrencyName;
        TextView mCurrencyRate;

        public CurrencyRatesItem(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mCurrencyName = itemView.findViewById(R.id.currency_name);
            mCurrencyRate = itemView.findViewById(R.id.currency_rate);
        }
    }
}
