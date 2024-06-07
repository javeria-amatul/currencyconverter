package com.javeria.currencyconverter.data.local.model

data class QuotedRate(
    val timestamp: Long = System.currentTimeMillis(),
    val perUnitConversion: String,
    val totalAmountConversion: String
)