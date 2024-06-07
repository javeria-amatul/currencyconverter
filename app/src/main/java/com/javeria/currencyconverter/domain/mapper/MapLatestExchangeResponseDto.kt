package com.javeria.currencyconverter.domain.mapper

import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.data.remote.dto.LatestExchangeRateDto
import javax.inject.Inject

class MapLatestExchangeResponseDtoToConversionModel @Inject constructor() {

    operator fun invoke(
        amount: Float,
        from: LatestExchangeRateDto,
        baseCurrencySymbol: String,
        targetCurrencySymbol: String
    ): QuotedRate {

        var exchangeRate = 0f
        if (from.data.aud > 0f) exchangeRate = from.data.aud
        if (from.data.eur > 0f) exchangeRate = from.data.eur
        if (from.data.bgn > 0f) exchangeRate = from.data.bgn
        if (from.data.brl > 0f) exchangeRate = from.data.brl
        if (from.data.cad > 0f) exchangeRate = from.data.cad
        if (from.data.chf > 0f) exchangeRate = from.data.chf
        if (from.data.cny > 0f) exchangeRate = from.data.cny
        if (from.data.czk > 0f) exchangeRate = from.data.czk
        if (from.data.dkk > 0f) exchangeRate = from.data.dkk
        if (from.data.gbp > 0f) exchangeRate = from.data.gbp
        if (from.data.huf > 0f) exchangeRate = from.data.huf
        if (from.data.idr > 0f) exchangeRate = from.data.idr
        if (from.data.ils > 0f) exchangeRate = from.data.ils
        if (from.data.inr > 0f) exchangeRate = from.data.inr
        if (from.data.isk > 0f) exchangeRate = from.data.isk
        if (from.data.jpy > 0f) exchangeRate = from.data.jpy
        if (from.data.krw > 0f) exchangeRate = from.data.krw
        if (from.data.mxn > 0f) exchangeRate = from.data.mxn
        if (from.data.myr > 0f) exchangeRate = from.data.myr
        if (from.data.nok > 0f) exchangeRate = from.data.nok
        if (from.data.nzd > 0f) exchangeRate = from.data.nzd
        if (from.data.pln > 0f) exchangeRate = from.data.pln
        if (from.data.ron > 0f) exchangeRate = from.data.ron
        if (from.data.rub > 0f) exchangeRate = from.data.rub
        if (from.data.sek > 0f) exchangeRate = from.data.sek
        if (from.data.sgd > 0f) exchangeRate = from.data.sgd
        if (from.data.thb > 0f) exchangeRate = from.data.thb
        if (from.data.sek > 0f) exchangeRate = from.data.sek
        if (from.data.sgd > 0f) exchangeRate = from.data.sgd
        if (from.data.thb > 0f) exchangeRate = from.data.thb
        if (from.data.tryCurrency > 0f) exchangeRate = from.data.tryCurrency
        if (from.data.usd > 0f) exchangeRate = from.data.usd
        if (from.data.zar > 0f) exchangeRate = from.data.zar

        val totalAmount = exchangeRate.times(amount)
        val perUnitConversion = "1${baseCurrencySymbol} = ${exchangeRate}${targetCurrencySymbol}"
        val total = "Total: ${amount}${baseCurrencySymbol} = ${totalAmount}${targetCurrencySymbol}"
        return QuotedRate(perUnitConversion = perUnitConversion, totalAmountConversion = total)
    }
}