package com.javeria.currencyconverter.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javeria.currencyconverter.data.local.model.RequestStatus
import com.javeria.currencyconverter.domain.common.Resource
import com.javeria.currencyconverter.domain.usecase.GetRequestStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val requestStatusUseCase: GetRequestStatusUseCase
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())

    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        getRequestStatus()
    }

    private fun getRequestStatus() {
        viewModelScope.launch {
            requestStatusUseCase().collect { requestStatus ->
                when (requestStatus) {
                    is Resource.Error -> {
                        emitState {
                            copy(
                                requestStatusUiState = RequestStatusUiState.Error
                            )
                        }
                    }

                    is Resource.Loading -> {
                        emitState {
                            copy(
                                requestStatusUiState = RequestStatusUiState.Loading
                            )
                        }
                    }

                    is Resource.Success -> {
                        requestStatus.data?.let {
                            emitState {
                                copy(
                                    requestStatusUiState = RequestStatusUiState.RequestStatusContent(it)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun emitState(block: HomeUiState.() -> HomeUiState) {
        _uiStateFlow.value = block(uiStateFlow.value)
    }
}