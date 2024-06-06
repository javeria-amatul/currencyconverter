package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.remote.repository.RequestStatusRepository
import com.javeria.currencyconverter.domain.common.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class GetRequestStatusUseCase @Inject constructor(
    private val requestStatusRepository: RequestStatusRepository,
) {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        try {
            val response = requestStatusRepository.getRequestStatus()
            if (response.isSuccessful) {
                val result = response.body()
                emit(Resource.Success(result))
            }
        } catch (e: IOException) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        } catch (e: TimeoutException) {
            emit(Resource.Error("Timeout Exception: ${e.message}"))
        }
    }
}