package com.javeria.currencyconverter.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javeria.currencyconverter.data.local.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `transaction`")
    fun getAllTransactions(): Flow<List<Transaction>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Transaction)
}