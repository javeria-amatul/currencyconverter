package com.javeria.currencyconverter.data.local.mapper

import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.model.QuotedRate
import javax.inject.Inject

class MapQuotedRateToTransactionsDao @Inject constructor() {

    operator fun invoke(from: QuotedRate): Transaction {
        return Transaction(
            perUnitConversion = from.perUnitConversion,
            total = from.totalAmountConversion
        )
    }
}