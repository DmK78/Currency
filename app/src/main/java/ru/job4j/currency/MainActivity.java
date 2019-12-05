package ru.job4j.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ru.job4j.currency.db.CurrencyRepository;
import ru.job4j.currency.model.Currency;
import ru.job4j.currency.network.NetworkService;

public class MainActivity extends AppCompatActivity {
    private Button buttonRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRefresh = findViewById(R.id.buttonRefresh);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), CurrencyPullService.class));
            }
        });
    }


}
