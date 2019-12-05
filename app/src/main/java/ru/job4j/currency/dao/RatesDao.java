package ru.job4j.currency.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.job4j.currency.model.Rates;


/**
 * interface CurrencyDao methods descriptions
 * @author Dmitry Kolganov (mailto:dmk78.inbox.ru)
 *  * @since 11.10.2019
 *  * @version $Id$
 */

@Dao
public interface RatesDao {

    @Query("SELECT * FROM rates")
    List<Rates> getAllRates();

    @Query("SELECT * FROM rates WHERE id == :id")
    Rates getRatesById(int id);

    @Insert
    void insertRates(Rates rates);

    @Delete
    void deleteRates(Rates rates);

    @Update
    void updateRates(Rates rates);

    @Query("DELETE FROM rates")
    void deleteAllRates();







}
