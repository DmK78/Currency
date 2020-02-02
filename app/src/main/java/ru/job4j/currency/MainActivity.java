package ru.job4j.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.List;

import ru.job4j.currency.db.CurrencyRepository;
import ru.job4j.currency.model.Currency;
import ru.job4j.currency.network.NetworkService;

public class MainActivity extends AppCompatActivity {
    private Button buttonRefresh;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRefresh = findViewById(R.id.buttonRefresh);
        buttonRefresh.setOnClickListener(this::startService);
    }

    public void startService(View view){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        int alarmType = AlarmManager.ELAPSED_REALTIME_WAKEUP;
        long timeOrLengthofWait = 0;
        Intent intentToFire = new Intent(this, CurrencyPullService.class);
        PendingIntent alarmIntent = PendingIntent.getService(this, 0, intentToFire, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(alarmType, timeOrLengthofWait, alarmIntent);
    }

}
