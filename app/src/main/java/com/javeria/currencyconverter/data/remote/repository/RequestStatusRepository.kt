package com.javeria.currencyconverter.data.remote.repository

import com.javeria.currencyconverter.data.remote.ApiService
import com.javeria.currencyconverter.data.remote.dto.RequestStatusResponseDto
import retrofit2.Response
import javax.inject.Inject

class RequestStatusRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getRequestStatus(): Response<RequestStatusResponseDto> =
        apiService.getRequestStatus()
}