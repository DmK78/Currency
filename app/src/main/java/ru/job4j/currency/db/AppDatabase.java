package ru.job4j.currency.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.job4j.currency.dao.CurrencyDao;
import ru.job4j.currency.dao.RatesDao;
import ru.job4j.currency.model.Currency;
import ru.job4j.currency.model.Rates;


/**
 * Class AppDatabase reoom database instance
 *
 * @author Dmitry Kolganov (mailto:dmk78.inbox.ru)
 * * @since 11.10.2019
 * * @version $Id$
 */

@Database(entities = {Currency.class, Rates.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "currencies.db";
    private static AppDatabase INSTANCE;

    public abstract RatesDao ratesDao();

    public abstract CurrencyDao currencyDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            // .allowMainThreadQueries()
                              .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
