package com.javeria.currencyconverter.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrencyResponseDto(@SerializedName("data") val data: Data)

data class Data(
    @SerializedName("EUR") val eur: CurrencyDto,
    @SerializedName("USD") val usd: CurrencyDto,
    @SerializedName("JPY") val jpy: CurrencyDto,
    @SerializedName("BGN") val bgn: CurrencyDto,
    @SerializedName("CZK") val czk: CurrencyDto,
    @SerializedName("DKK") val dkk: CurrencyDto,
    @SerializedName("GBP") val gbp: CurrencyDto,
    @SerializedName("HUF") val huf: CurrencyDto,
    @SerializedName("PLN") val pln: CurrencyDto,
    @SerializedName("RON") val ron: CurrencyDto,
    @SerializedName("SEK") val sek: CurrencyDto,
    @SerializedName("CHF") val chf: CurrencyDto,
    @SerializedName("ISK") val isk: CurrencyDto,
    @SerializedName("NOK") val nok: CurrencyDto,
    @SerializedName("HRK") val hrk: CurrencyDto,
    @SerializedName("RUB") val rub: CurrencyDto,
    @SerializedName("TRY") val tryC: CurrencyDto,
    @SerializedName("AUD") val aud: CurrencyDto,
    @SerializedName("BRL") val brl: CurrencyDto,
    @SerializedName("CAD") val cad: CurrencyDto,
    @SerializedName("CNY") val cny: CurrencyDto,
    @SerializedName("HKD") val hkd: CurrencyDto,
    @SerializedName("IDR") val idr: CurrencyDto,
    @SerializedName("ILS") val ils: CurrencyDto,
    @SerializedName("INR") val inr: CurrencyDto,
    @SerializedName("KRW") val krw: CurrencyDto,
    @SerializedName("MXN") val mxn: CurrencyDto,
    @SerializedName("MYR") val myr: CurrencyDto,
    @SerializedName("NZD") val nzd: CurrencyDto,
    @SerializedName("PHP") val php: CurrencyDto,
    @SerializedName("SGD") val sgd: CurrencyDto,
    @SerializedName("THB") val thb: CurrencyDto,
    @SerializedName("ZAR") val zar: CurrencyDto,
)

data class CurrencyDto(val symbol: String, val name: String, val code: String)

