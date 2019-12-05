package ru.job4j.currency.db;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.job4j.currency.model.Currency;

public class CurrencyRepository {

    private AppDatabase appDatabase;
    private static CurrencyRepository mInstance;
    private Context context;

    /**
     * Class CurrencyRepository methods implementations
     * @author Dmitry Kolgabov (mailto:dmk78.inbox.ru)
     *  * @since 11.10.2019
     *  * @version $Id$
     */
    private CurrencyRepository(Context context) {
        this.context = context;
        appDatabase = AppDatabase.getInstance(context);
    }

    public static synchronized CurrencyRepository getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CurrencyRepository(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }


    public List<Currency> getCurrencies() {
        List<Currency> result = new ArrayList<>();
        class GetCurrenciesTask extends AsyncTask<Void, Void, List<Currency>> {

            @Override
            protected List<Currency> doInBackground(Void... voids) {
                List<Currency> currencies = appDatabase
                        .currencyDao()
                        .getAllCurrencies();
                return currencies;
            }

            @Override
            protected void onPostExecute(final List<Currency> currencies) {
                super.onPostExecute(currencies);
            }
        }
        GetCurrenciesTask gt = new GetCurrenciesTask();
        try {
            result = gt.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveCurrency(final Currency currency) {
        class SaveCurrencyTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase
                        .currencyDao()
                        .insertCurrency(currency);
                return null;
            }
            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
                Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();

            }
        }
        SaveCurrencyTask st = new SaveCurrencyTask();
        st.execute();

    }

    public void deleteCurrency(final Currency currency) {
        class DeleteCurrencyTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase
                        .currencyDao()
                        .deleteCurrency(currency);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
            }
        }
        DeleteCurrencyTask dt = new DeleteCurrencyTask();
        dt.execute();
    }

    public Currency getCurrencyById(int id) {
        Currency result = null;
        class GetCurrencyById extends AsyncTask<Integer, Void, Currency> {

            @Override
            protected Currency doInBackground(Integer... integers) {
                Currency currency = appDatabase
                        .currencyDao()
                        .getCurrencyById(integers[0]);
                return currency;
            }

            @Override
            protected void onPostExecute(Currency currency) {
                super.onPostExecute(currency);
            }
        }
        GetCurrencyById gt = new GetCurrencyById();
        try {
            result = gt.execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateCurrency(final Currency currency) {
        class SaveBdActionTask extends AsyncTask<Currency, Void, Void> {
            @Override
            protected Void doInBackground(Currency... currencies) {
                appDatabase
                        .currencyDao()
                        .updateCurrency(currency);
                return null;
            }
            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
                Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show();

            }
        }
        SaveBdActionTask st = new SaveBdActionTask();
        st.execute();
    }

}
