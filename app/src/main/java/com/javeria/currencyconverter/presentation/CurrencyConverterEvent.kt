package com.javeria.currencyconverter.presentation

import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.local.model.QuotedRate

sealed class CurrencyConverterEvent {
    data class BaseCurrencySelected(val currency: Currency) : CurrencyConverterEvent()
    data class TargetCurrencySelected(val currency: Currency) : CurrencyConverterEvent()
    data class ConvertCurrencyClicked(val amount: String) :
        CurrencyConverterEvent()
    data object DialogDismissOrTransactionDenied : CurrencyConverterEvent()
    data class SaveConversionInLocal(val quotedRate: QuotedRate) : CurrencyConverterEvent()
}