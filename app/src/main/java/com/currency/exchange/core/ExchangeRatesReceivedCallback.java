package com.currency.exchange.core;

public interface ExchangeRatesReceivedCallback {
    void onSuccess(CurrencyRatesModel rates);
    void onError(Throwable error);
}
