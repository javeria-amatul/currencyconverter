package com.javeria.currencyconverter.domain.mapper

import com.javeria.currencyconverter.data.local.model.RequestStatus
import com.javeria.currencyconverter.data.remote.dto.RequestStatusResponseDto
import javax.inject.Inject

class MapRequestStatusResponseDtoToRequestStatusResult @Inject constructor(){

    operator fun invoke(from: RequestStatusResponseDto): RequestStatus {
        val monthStatus = from.quotas.month
        return RequestStatus(
            total = monthStatus.total,
            used = monthStatus.used,
            remaining = monthStatus.remaining
        )
    }
}