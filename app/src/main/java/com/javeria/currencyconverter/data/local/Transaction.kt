package com.javeria.currencyconverter.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    val perUnitConversion: String?,
    val total: String?,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}