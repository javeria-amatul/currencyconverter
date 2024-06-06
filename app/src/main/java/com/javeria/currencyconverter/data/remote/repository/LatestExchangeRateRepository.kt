package com.javeria.currencyconverter.data.remote.repository

import com.javeria.currencyconverter.data.remote.ApiService
import com.javeria.currencyconverter.data.remote.dto.LatestExchangeRateDto
import retrofit2.Response
import javax.inject.Inject

class LatestExchangeRateRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getLatestExchangeRate(
        baseCurrency: String,
        targetCurrency: String
    ): Response<LatestExchangeRateDto> =
        apiService.getLatestExchangeRates( baseCurrency = baseCurrency, targetCurrency = listOf(targetCurrency))
}