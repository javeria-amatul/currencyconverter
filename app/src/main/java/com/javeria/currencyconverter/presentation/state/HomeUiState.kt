package com.javeria.currencyconverter.presentation.state

import com.javeria.currencyconverter.data.local.model.RequestStatus


data class HomeUiState(val requestStatusUiState: RequestStatusUiState = RequestStatusUiState.Loading)




sealed class RequestStatusUiState {
    object Loading: RequestStatusUiState()
    object Error: RequestStatusUiState()
    data class RequestStatusContent(val requestStatus: RequestStatus): RequestStatusUiState()
}