package com.javeria.currencyconverter.data.remote.repository

import com.javeria.currencyconverter.data.remote.ApiService
import com.javeria.currencyconverter.data.remote.dto.CurrencyResponseDto
import retrofit2.Response
import javax.inject.Inject

class CurrencyListRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCurrencyList(): Response<CurrencyResponseDto> =
        apiService.getCurrencyList()
}
