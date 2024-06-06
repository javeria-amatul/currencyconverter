package com.javeria.currencyconverter.data.remote

import com.javeria.currencyconverter.BuildConfig
import com.javeria.currencyconverter.BuildConfig.API_KEY
import com.javeria.currencyconverter.data.remote.dto.CurrencyResponseDto
import com.javeria.currencyconverter.data.remote.dto.LatestExchangeRateDto
import com.javeria.currencyconverter.data.remote.dto.RequestStatusResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("status")
    suspend fun getRequestStatus(@Query("apikey") apiKey: String = BuildConfig.API_KEY): Response<RequestStatusResponseDto>

    @GET("currencies")
    suspend fun getCurrencyList(
        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
        @Query("currencies") currencies: String = ""
    ): Response<CurrencyResponseDto>

    @GET("latest")
    suspend fun getLatestExchangeRates(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("base_currency") baseCurrency: String,
        @Query("currencies") targetCurrency: List<String>
    ): Response<LatestExchangeRateDto>
}