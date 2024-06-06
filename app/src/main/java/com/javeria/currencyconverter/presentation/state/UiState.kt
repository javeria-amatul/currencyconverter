package com.javeria.currencyconverter.presentation.state

import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.model.RequestStatus


data class UiState(
    val requestStatusUiState: RequestStatusUiState = RequestStatusUiState.Loading,
    val currencyConverterUiState: CurrencyConverterUiState = CurrencyConverterUiState.Loading,
    val quotedState: QuotedConverterUiState? = null,
    val amount: String = "",
    val baseCurrency: Currency? = null,
    val targetCurrency: Currency? = null,
    val baseCurrencySelected: (Currency) -> Unit = {},
    val targetCurrencySelected: (Currency) -> Unit = {},
    val convertButtonClicked: () -> Unit = {}
)


sealed class RequestStatusUiState {
    data object Loading : RequestStatusUiState()
    data object Error : RequestStatusUiState()
    data class RequestStatusContent(val requestStatus: RequestStatus) : RequestStatusUiState()
}


sealed class CurrencyConverterUiState {
    data object Loading : CurrencyConverterUiState()
    data object Error : CurrencyConverterUiState()
    data class CurrencyListSuccess(val currencyList: List<Currency>?) : CurrencyConverterUiState()
}

sealed class QuotedConverterUiState {
    data object Loading : QuotedConverterUiState()
    data object Error : QuotedConverterUiState()
    data class QuotedRateSuccess(val quotedRate: QuotedRate?) : QuotedConverterUiState()
}