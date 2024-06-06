package com.javeria.currencyconverter.data.local.model

data class QuotedRate(
    val quotedConversionRate: Float,
    val baseAmount: Float,
    val totalAmount: Float,
    val baseCurrencySymbol: String,
    val targetCurrencySymbol: String
)