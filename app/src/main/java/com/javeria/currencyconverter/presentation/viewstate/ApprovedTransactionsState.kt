package com.javeria.currencyconverter.presentation.viewstate

import com.javeria.currencyconverter.data.local.model.QuotedRate


sealed class ApprovedTransactionsState {

    data object NoData : ApprovedTransactionsState()
    data class Content(val list: List<QuotedRate>) : ApprovedTransactionsState()
}