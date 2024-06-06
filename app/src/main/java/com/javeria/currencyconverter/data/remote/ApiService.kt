package com.javeria.currencyconverter.data.remote

import com.javeria.currencyconverter.BuildConfig
import com.javeria.currencyconverter.data.remote.dto.RequestStatusResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("status")
    suspend fun getRequestStatus(@Query("apikey") apiKey: String = BuildConfig.API_KEY): Response<RequestStatusResponseDto>

}