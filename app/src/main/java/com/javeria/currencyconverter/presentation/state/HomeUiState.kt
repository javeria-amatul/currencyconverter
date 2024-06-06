package com.javeria.currencyconverter.presentation.state

import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.local.model.RequestStatus


data class HomeUiState(
    val requestStatusUiState: RequestStatusUiState = RequestStatusUiState.Loading,
    val currencyConverterUiState: CurrencyConverterUiState = CurrencyConverterUiState.Loading,
    val amount: String = "",
    val baseCurrencySelected: (String) -> Unit = {},
    val targetCurrencySelected: (String) -> Unit = {},
    val convertButtonClicked: () -> Unit = {},
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