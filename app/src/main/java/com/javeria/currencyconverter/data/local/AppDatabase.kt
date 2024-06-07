package com.javeria.currencyconverter.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.javeria.currencyconverter.data.local.dao.TransactionDao

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        const val DATABASE_NAME = "transactions.db"
    }
}