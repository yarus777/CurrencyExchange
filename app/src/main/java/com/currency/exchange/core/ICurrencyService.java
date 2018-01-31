package com.currency.exchange.core;

public interface ICurrencyService {
    void getRates(final ExchangeRatesReceivedCallback callback);
}
