package ru.job4j.currency.db;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.job4j.currency.model.Rates;

public class RatesRepository {

    private AppDatabase appDatabase;
    private static RatesRepository mInstance;
    private Context context;

    /**
     * Class CurrencyRepository methods implementations
     * @author Dmitry Kolgabov (mailto:dmk78.inbox.ru)
     *  * @since 11.10.2019
     *  * @version $Id$
     */
    private RatesRepository(Context context) {
        this.context = context;
        appDatabase = AppDatabase.getInstance(context);
    }

    public static synchronized RatesRepository getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RatesRepository(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }


    public List<Rates> getRates() {
        List<Rates> result = new ArrayList<>();
        class GetRates extends AsyncTask<Void, Void, List<Rates>> {

            @Override
            protected List<Rates> doInBackground(Void... voids) {
                List<Rates> bdActions = appDatabase
                        .ratesDao()
                        .getAllRates();
                return bdActions;
            }

            @Override
            protected void onPostExecute(final List<Rates> rates) {
                super.onPostExecute(rates);
            }
        }
        GetRates getRates = new GetRates();
        try {
            result = getRates.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveRates(final Rates rates) {
        class SaveRatesTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase
                        .ratesDao()
                        .insertRates(rates);
                return null;
            }
            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
                Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();

            }
        }
        SaveRatesTask st = new SaveRatesTask();
        st.execute();

    }

    public void deleteRates(final Rates rates) {
        class DeleteRates extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase
                        .ratesDao()
                        .deleteRates(rates);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
            }
        }
        DeleteRates dt = new DeleteRates();
        dt.execute();
    }

    public Rates getRatesById(int id) {
        Rates result = null;
        class GetRatesById extends AsyncTask<Integer, Void, Rates> {

            @Override
            protected Rates doInBackground(Integer... integers) {
                Rates rates = appDatabase
                        .ratesDao()
                        .getRatesById(integers[0]);
                return rates;
            }

            @Override
            protected void onPostExecute(Rates rates) {
                super.onPostExecute(rates);
            }
        }
        GetRatesById gt = new GetRatesById();
        try {
            result = gt.execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateRates(final Rates rates) {
        class SaveRatesTask extends AsyncTask<Rates, Void, Void> {
            @Override
            protected Void doInBackground(Rates... bdActions) {
                appDatabase
                        .ratesDao()
                        .updateRates(rates);
                return null;
            }
            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
                Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show();

            }
        }
        SaveRatesTask st = new SaveRatesTask();
        st.execute();
    }

}
