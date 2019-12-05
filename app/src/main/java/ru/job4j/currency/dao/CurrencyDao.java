package ru.job4j.currency.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.job4j.currency.model.Currency;


/**
 * interface CurrencyDao methods descriptions
 * @author Dmitry Kolganov (mailto:dmk78.inbox.ru)
 *  * @since 11.10.2019
 *  * @version $Id$
 */

@Dao
public interface CurrencyDao {

    @Query("SELECT * FROM currencies")
    List<Currency> getAllCurrencies();

    @Query("SELECT * FROM currencies WHERE id == :id")
    Currency getCurrencyById(int id);

    @Insert
    void insertCurrency(Currency currency);

    @Delete
    void deleteCurrency(Currency currency);

    @Update
    void updateCurrency(Currency currency);

    @Query("DELETE FROM currencies")
    void deleteAllCurrencies();







}
