package ru.job4j.currency.network;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.job4j.currency.model.Currency;


public interface JsonPlaceHolderApi {
    @GET("latest")
    Call<Currency> getLatestRates();

    /*@GET("task.json")
    Call<List<Worker>> getWorkersBySpeciality(@Query("specialty") int speciality_id);

    @GET("task.json")
    Call<Worker> getWorker(
            @Query("f_name") String firstName,
            @Query("l_name") String lastName,
            @Query("birthday") String birthday
    );*/
}
