package com.javeria.currencyconverter.data.local.repository

import com.javeria.currencyconverter.data.local.AppDatabase
import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.mapper.MapTransactionsDaoToQuotedRate
import com.javeria.currencyconverter.data.local.model.QuotedRate
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val mapTransactionsDaoToQuotedRate: MapTransactionsDaoToQuotedRate
) {

    fun getTransaction(): List<QuotedRate> {
        val transactionsInDb = appDatabase.transactionDao().getAll()
        val listOfQuotedRate = arrayListOf<QuotedRate>()
        transactionsInDb.forEach { transaction ->
            listOfQuotedRate.add(mapTransactionsDaoToQuotedRate.invoke(transaction))
        }
        return listOfQuotedRate
    }


    fun saveTransaction(quotedRate: QuotedRate) {
        val transaction = Transaction(
            perUnitConversion = quotedRate.perUnitConversion,
            total = quotedRate.totalAmountConversion
        )
        appDatabase.transactionDao().insert(transaction)
    }
}