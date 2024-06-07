package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.local.mapper.MapQuotedRateToTransactionsDao
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.repository.OfflineTransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveApprovedTransactions @Inject constructor(
    private val offlineTransactionRepository: OfflineTransactionRepository,
    private val mapQuotedRateToTransactionsDao: MapQuotedRateToTransactionsDao) {

    operator fun invoke(quotedRate: QuotedRate) {
        val transaction = mapQuotedRateToTransactionsDao.invoke(quotedRate)
        CoroutineScope(Dispatchers.IO).launch {
            offlineTransactionRepository.insertTransaction(transaction)
        }
    }
}