package ru.job4j.currency;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class CurrencyPullService extends IntentService {
    private static final String TAG = CurrencyPullService.class.getName();

    public CurrencyPullService() {
        super("CurrencyPullService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "execute a task in a service");
    }
}
