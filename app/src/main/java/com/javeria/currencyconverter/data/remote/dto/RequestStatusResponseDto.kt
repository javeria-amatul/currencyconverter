package com.javeria.currencyconverter.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RequestStatusResponseDto(@SerializedName("quotas") var quotas: Quotas)

data class Quotas(@SerializedName("month") var month: Month)

data class Month(
    @SerializedName("total") var total: Int,
    @SerializedName("used") var used: Int,
    @SerializedName("remaining") var remaining: Int
)