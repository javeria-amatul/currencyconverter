package com.javeria.currencyconverter.data.local.repository

import com.javeria.currencyconverter.data.local.Transaction
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert and retrieve of [Transaction] from a given data source.
 */
interface TransactionRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllTransactionsStream(): Flow<List<Transaction>>

    /**
     * Insert transaction in the data source
     */
    suspend fun insertTransaction(item: Transaction)
}
