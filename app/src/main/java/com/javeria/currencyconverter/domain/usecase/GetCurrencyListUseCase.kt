package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.remote.repository.CurrencyListRepository
import com.javeria.currencyconverter.domain.common.Resource
import com.javeria.currencyconverter.domain.mapper.MapCurrencyResponseDtoToListOfCurrency
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(
    private val currencyListRepository: CurrencyListRepository,
    private val mapCurrencyResponseDtoToListOfCurrency: MapCurrencyResponseDtoToListOfCurrency
) {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        try {
            val response = currencyListRepository.getCurrencyList()
            if (response.isSuccessful) {
                val result = response.body()
                result?.let {
                    val currencyList = mapCurrencyResponseDtoToListOfCurrency(it)
                    emit(Resource.Success(currencyList))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        } catch (e: TimeoutException) {
            emit(Resource.Error("Timeout Exception: ${e.message}"))
        }
    }
}