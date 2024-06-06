package com.javeria.currencyconverter.domain.mapper

import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.remote.dto.CurrencyResponseDto
import javax.inject.Inject

class MapCurrencyResponseDtoToListOfCurrency @Inject constructor() {

    operator fun invoke(from: CurrencyResponseDto): List<Currency> {
        val currencies = from.data
        return arrayListOf<Currency>().apply {
            add(Currency(currencies.eur.symbol, currencies.eur.name, currencies.eur.code))
            add(Currency(currencies.usd.symbol, currencies.usd.name, currencies.usd.code))
            add(Currency(currencies.jpy.symbol, currencies.jpy.name, currencies.jpy.code))
            add(Currency(currencies.bgn.symbol, currencies.bgn.name, currencies.bgn.code))
            add(Currency(currencies.czk.symbol, currencies.czk.name, currencies.czk.code))
            add(Currency(currencies.dkk.symbol, currencies.dkk.name, currencies.dkk.code))
            add(Currency(currencies.gbp.symbol, currencies.gbp.name, currencies.gbp.code))
            add(Currency(currencies.huf.symbol, currencies.huf.name, currencies.huf.code))
            add(Currency(currencies.pln.symbol, currencies.pln.name, currencies.pln.code))
            add(Currency(currencies.ron.symbol, currencies.ron.name, currencies.ron.code))
            add(Currency(currencies.sek.symbol, currencies.sek.name, currencies.sek.code))
            add(Currency(currencies.chf.symbol, currencies.chf.name, currencies.chf.code))
            add(Currency(currencies.isk.symbol, currencies.isk.name, currencies.isk.code))
            add(Currency(currencies.nok.symbol, currencies.nok.name, currencies.nok.code))
            add(Currency(currencies.hrk.symbol, currencies.hrk.name, currencies.hrk.code))
            add(Currency(currencies.rub.symbol, currencies.rub.name, currencies.rub.code))
            add(Currency(currencies.aud.symbol, currencies.aud.name, currencies.aud.code))
            add(Currency(currencies.brl.symbol, currencies.brl.name, currencies.brl.code))
            add(Currency(currencies.cny.symbol, currencies.cny.name, currencies.cny.code))
            add(Currency(currencies.hkd.symbol, currencies.hkd.name, currencies.hkd.code))
            add(Currency(currencies.idr.symbol, currencies.idr.name, currencies.idr.code))
            add(Currency(currencies.ils.symbol, currencies.ils.name, currencies.ils.code))
            add(Currency(currencies.inr.symbol, currencies.inr.name, currencies.inr.code))
            add(Currency(currencies.krw.symbol, currencies.krw.name, currencies.krw.code))
            add(Currency(currencies.mxn.symbol, currencies.mxn.name, currencies.mxn.code))
            add(Currency(currencies.myr.symbol, currencies.myr.name, currencies.myr.code))
            add(Currency(currencies.nzd.symbol, currencies.nzd.name, currencies.nzd.code))
            add(Currency(currencies.sgd.symbol, currencies.sgd.name, currencies.sgd.code))
            add(Currency(currencies.thb.symbol, currencies.thb.name, currencies.thb.code))
            add(Currency(currencies.zar.symbol, currencies.zar.name, currencies.zar.code))
            add(Currency(currencies.tryC.symbol, currencies.tryC.name, currencies.tryC.code))
        }
    }
}