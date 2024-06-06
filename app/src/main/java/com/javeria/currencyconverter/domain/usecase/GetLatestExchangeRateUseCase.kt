package com.javeria.currencyconverter.domain.usecase

import com.javeria.currencyconverter.data.local.model.Conversion
import com.javeria.currencyconverter.data.remote.repository.LatestExchangeRateRepository
import com.javeria.currencyconverter.domain.common.Resource
import com.javeria.currencyconverter.domain.mapper.MapLatestExchangeResponseDtoToConversionModel
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject


class GetLatestExchangeRateUseCase @Inject constructor(
    private val latestExchangeRateRepository: LatestExchangeRateRepository,
    private val mapLatestExchangeResponseDtoToConversionModel: MapLatestExchangeResponseDtoToConversionModel
) {
    operator fun invoke(conversion: Conversion) = flow {
        emit(Resource.Loading())
        try {
            val response =
                latestExchangeRateRepository.getLatestExchangeRate(
                    conversion.baseCurrency.code,
                    conversion.targetCurrency.code
                )
            if (response.isSuccessful) {
                val result = response.body()
                result?.let {
                    val quotedRate =
                        mapLatestExchangeResponseDtoToConversionModel(
                            conversion.amount,
                            it,
                            conversion.baseCurrency.symbol,
                            conversion.targetCurrency.symbol
                        )
                    //Improvement: ideally create a string provider here and send the text to be shown to user
                    emit(Resource.Success(quotedRate))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        } catch (e: TimeoutException) {
            emit(Resource.Error("Timeout Exception: ${e.message}"))
        }
    }
}