package ru.job4j.currency;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.job4j.currency.db.CurrencyRepository;
import ru.job4j.currency.model.Currency;
import ru.job4j.currency.network.NetworkService;

public class CurrencyPullService extends IntentService {
    private static final String TAG = CurrencyPullService.class.getName();
    private NetworkService networkService = NetworkService.getInstance();
    private Currency currency;
    private CurrencyRepository currencyRepository;

    public CurrencyPullService() {
        super("CurrencyPullService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        currencyRepository = CurrencyRepository.getInstance(getApplicationContext());
        Log.d(TAG, "execute a task in a service");
        networkService.getJSONApi().getLatestRates().enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                if (response.isSuccessful()) {
                    currency = response.body();
                    currencyRepository.saveCurrency(currency);
                    List<Currency> currenciesFromDb = currencyRepository.getCurrencies();
                    int count = 0;
                    for (Currency currency : currenciesFromDb) {
                        Log.d(TAG, "" + count++ + " " + currency.toString());
                        Log.d(TAG, currency.getRates().getRUB().toString());
                        Log.d(TAG, currency.getRates().getUSD().toString());
                    }
                    //stopSelf();
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

            }
        });
    }
}
