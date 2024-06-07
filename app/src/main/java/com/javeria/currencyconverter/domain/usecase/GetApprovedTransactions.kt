package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.local.mapper.MapTransactionsDaoToQuotedRate
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.repository.OfflineTransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetApprovedTransactions @Inject constructor(
    private val offlineTransactionRepository: OfflineTransactionRepository,
    private val mapTransactionsDaoToQuotedRate: MapTransactionsDaoToQuotedRate
) {
    operator fun invoke(): Flow<List<QuotedRate>> {
        return offlineTransactionRepository.getAllTransactionsStream()
            .map { transactionList ->
                transactionList.map { transaction ->
                    mapTransactionsDaoToQuotedRate(transaction)
                }
            }
    }

}