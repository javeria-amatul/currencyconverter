package com.javeria.currencyconverter.presentation.viewstate

import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.local.model.RequestStatus


data class UiState(
    val requestStatusUiState: RequestStatusUiState = RequestStatusUiState.Loading,
    val currencyConverterUiState: CurrencyConverterUiState = CurrencyConverterUiState.Loading,
    var quotedState: QuotedConverterUiState? = null,
    val approvedTransactionsState: ApprovedTransactionsState = ApprovedTransactionsState.NoData,
    val amount: String = "",
    val baseCurrency: Currency? = null,
    val targetCurrency: Currency? = null,
    val baseCurrencySelected: (Currency) -> Unit = {},
    val targetCurrencySelected: (Currency) -> Unit = {},
    val convertButtonClicked: () -> Unit = {},
    val recentTransactionsClicked: (Boolean) -> Unit = {},
    val showBottomSheet: Boolean = false
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
    data class QuotedRateSuccess(val quotedRate: QuotedRate? = null,  val showDialog: Boolean) : QuotedConverterUiState()
}
