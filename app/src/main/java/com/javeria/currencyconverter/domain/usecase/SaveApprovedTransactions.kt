package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.repository.TransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveApprovedTransactions @Inject constructor(val transactionRepository: TransactionRepository) {

    operator fun invoke(quotedRate: QuotedRate) {
        CoroutineScope(Dispatchers.IO).launch {
            transactionRepository.saveTransaction(quotedRate)
        }
    }

}