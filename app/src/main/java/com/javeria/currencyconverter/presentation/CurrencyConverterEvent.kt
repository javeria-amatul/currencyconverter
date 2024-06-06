package com.javeria.currencyconverter.presentation

import com.javeria.currencyconverter.data.local.model.Currency

sealed class CurrencyConverterEvent {
    data class BaseCurrencySelected(val currency: Currency) : CurrencyConverterEvent()
    data class TargetCurrencySelected(val currency: Currency) : CurrencyConverterEvent()
    data class ConvertCurrencyClicked(val amount: String) :
        CurrencyConverterEvent()
}