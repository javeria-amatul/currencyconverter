package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.repository.TransactionRepository
import javax.inject.Inject

class GetApprovedTransactions @Inject constructor(val transactionRepository: TransactionRepository) {

    operator fun invoke(): List<QuotedRate> {
            return transactionRepository.getTransaction()
    }

}