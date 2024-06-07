package com.javeria.currencyconverter.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.javeria.currencyconverter.data.local.AppDatabase
import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.dao.TransactionDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TransactionDaoTest {

    private lateinit var transactionDao: TransactionDao
    private lateinit var appDatabase: AppDatabase
    private val transaction1 = Transaction("10.0", "20")
    private val transaction2 = Transaction("15.0", "97")

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        transactionDao = appDatabase.transactionDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsTransactionIntoDB() = runBlocking {
        addOneItemToDb()
        val allItems = transactionDao.getAllTransactions().first()
        assertEquals(allItems[0], transaction1)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetAllItems_returnsAllTransactionsFromDB() = runBlocking {
        addTwoItemsToDb()
        val allItems = transactionDao.getAllTransactions().first()
        assertEquals(allItems[0], transaction1)
        assertEquals(allItems[1], transaction2)
    }


    private fun addOneItemToDb() {
        transactionDao.insert(transaction1)
    }

    private fun addTwoItemsToDb() {
        transactionDao.insert(transaction1)
        transactionDao.insert(transaction2)
    }
}
