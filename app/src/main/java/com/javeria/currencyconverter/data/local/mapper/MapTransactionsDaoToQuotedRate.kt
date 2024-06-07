package com.javeria.currencyconverter.data.local.mapper

import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.model.QuotedRate
import javax.inject.Inject

class MapTransactionsDaoToQuotedRate @Inject constructor() {

    operator fun invoke(from: Transaction): QuotedRate {
        return QuotedRate(
            perUnitConversion = from.perUnitConversion ?: "",
            totalAmountConversion = from.total ?: ""
        )
    }
}