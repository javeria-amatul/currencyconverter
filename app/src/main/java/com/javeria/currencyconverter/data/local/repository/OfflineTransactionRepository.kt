package com.javeria.currencyconverter.data.local.repository

import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.dao.TransactionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineTransactionRepository @Inject constructor(private val transactionDao: TransactionDao): TransactionRepository {

    override fun getAllTransactionsStream(): Flow<List<Transaction>> = transactionDao.getAllTransactions()
    override suspend fun insertTransaction(item: Transaction)  = transactionDao.insert(item)

}