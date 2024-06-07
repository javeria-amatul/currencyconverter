package com.javeria.currencyconverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javeria.currencyconverter.data.local.model.Conversion
import com.javeria.currencyconverter.domain.common.Resource
import com.javeria.currencyconverter.domain.usecase.GetCurrencyListUseCase
import com.javeria.currencyconverter.domain.usecase.GetLatestExchangeRateUseCase
import com.javeria.currencyconverter.domain.usecase.GetRequestStatusUseCase
import com.javeria.currencyconverter.presentation.viewstate.CurrencyConverterUiState
import com.javeria.currencyconverter.presentation.viewstate.QuotedConverterUiState
import com.javeria.currencyconverter.presentation.viewstate.RequestStatusUiState
import com.javeria.currencyconverter.presentation.viewstate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val requestStatusUseCase: GetRequestStatusUseCase,
    private val currencyListUseCase: GetCurrencyListUseCase,
    private val getLatestExchangeRateUseCase: GetLatestExchangeRateUseCase,
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {
        getRequestStatus()
        getCurrencyList()
    }

    fun dispatch(event: CurrencyConverterEvent) {
        when (event) {
            is CurrencyConverterEvent.BaseCurrencySelected -> {
                emitState {
                    copy(
                        baseCurrencySelected = { event.currency }, baseCurrency = event.currency
                    )
                }
            }

            is CurrencyConverterEvent.ConvertCurrencyClicked -> {
                emitState {
                    copy(amount = event.amount, convertButtonClicked = { event.amount })
                }
                getConversion()
            }

            is CurrencyConverterEvent.TargetCurrencySelected -> {
                emitState {
                    copy(
                        targetCurrencySelected = { event.currency }, targetCurrency = event.currency
                    )
                }
            }

            CurrencyConverterEvent.DialogDismissOrTransactionDenied -> emitState {
                copy(
                    quotedState = QuotedConverterUiState.QuotedRateSuccess(showDialog = false)
                )
            }

            is CurrencyConverterEvent.SaveConversionInLocal -> {

            }
        }
    }


    private fun getConversion() {
        viewModelScope.launch {
            try {
                if (uiStateFlow.value.baseCurrency != null
                    && uiStateFlow.value.targetCurrency != null
                    && uiStateFlow.value.amount.toFloat() > 0f
                ) {
                    val conversion = Conversion(
                        uiStateFlow.value.amount.toFloat(),
                        uiStateFlow.value.baseCurrency!!,
                        uiStateFlow.value.targetCurrency!!
                    )
                    getLatestExchangeRateUseCase(conversion).collect { quotedRateState ->
                        when (quotedRateState) {
                            is Resource.Error -> {
                                emitState {
                                    copy(
                                        quotedState = QuotedConverterUiState.Error
                                    )
                                }
                            }

                            is Resource.Loading -> {
                                emitState {
                                    copy(
                                        quotedState = QuotedConverterUiState.Loading
                                    )
                                }
                            }

                            is Resource.Success -> {
                                emitState {
                                    copy(
                                        quotedState = QuotedConverterUiState.QuotedRateSuccess(
                                            quotedRateState.data, true
                                        )
                                    )
                                }
                            }
                        }

                    }
                }
            } catch (ex: Exception) {
                emitState {
                    copy(
                        quotedState = QuotedConverterUiState.Error
                    )
                }
            }
        }
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
                                    requestStatusUiState = RequestStatusUiState.RequestStatusContent(
                                        it
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getCurrencyList() {
        viewModelScope.launch {
            currencyListUseCase.invoke().collect { currencyList ->
                when (currencyList) {
                    is Resource.Error -> {
                        emitState {
                            copy(
                                currencyConverterUiState = CurrencyConverterUiState.Error
                            )
                        }
                    }

                    is Resource.Loading -> {
                        emitState {
                            copy(
                                currencyConverterUiState = CurrencyConverterUiState.Loading
                            )
                        }
                    }

                    is Resource.Success -> {
                        emitState {
                            copy(
                                currencyConverterUiState = CurrencyConverterUiState.CurrencyListSuccess(
                                    currencyList.data
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    private fun emitState(block: UiState.() -> UiState) {
        _uiStateFlow.value = block(uiStateFlow.value)
    }
}