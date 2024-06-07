package com.javeria.currencyconverter.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javeria.currencyconverter.data.local.Transaction

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `transaction`")
    fun getAll(): List<Transaction>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Transaction)
}