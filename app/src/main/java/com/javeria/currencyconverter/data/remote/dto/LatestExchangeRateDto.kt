package com.javeria.currencyconverter.data.remote.dto

import com.google.gson.annotations.SerializedName


data class LatestExchangeRateDto(val data: LatestExchangeRateData)

data class LatestExchangeRateData(
    @SerializedName("AUD") val aud: Float,
    @SerializedName("EUR") val eur: Float,
    @SerializedName("BGN") val bgn: Float,
    @SerializedName("BRL") val brl: Float,
    @SerializedName("USD") val usd: Float,
    @SerializedName("JPY") val jpy: Float,
    @SerializedName("CZK") val czk: Float,
    @SerializedName("DKK") val dkk: Float,
    @SerializedName("GBP") val gbp: Float,
    @SerializedName("HUF") val huf: Float,
    @SerializedName("PLN") val pln: Float,
    @SerializedName("RON") val ron: Float,
    @SerializedName("SEK") val sek: Float,
    @SerializedName("CHF") val chf: Float,
    @SerializedName("ISK") val isk: Float,
    @SerializedName("NOK") val nok: Float,
    @SerializedName("HRK") val hrk: Float,
    @SerializedName("RUB") val rub: Float,
    @SerializedName("TRY") val tryCurrency: Float,
    @SerializedName("CAD") val cad: Float,
    @SerializedName("CNY") val cny: Float,
    @SerializedName("HKD") val hkd: Float,
    @SerializedName("IDR") val idr: Float,
    @SerializedName("ILS") val ils: Float,
    @SerializedName("INR") val inr: Float,
    @SerializedName("KRW") val krw: Float,
    @SerializedName("MXN") val mxn: Float,
    @SerializedName("MYR") val myr: Float,
    @SerializedName("NZD") val nzd: Float,
    @SerializedName("PHP") val php: Float,
    @SerializedName("SGD") val sgd: Float,
    @SerializedName("THB") val thb: Float,
    @SerializedName("ZAR") val zar: Float,
)



