package com.javeria.currencyconverter.data.local.mapper

import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.model.QuotedRate
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MapQuotedRateToTransactionsDaoTest {

    private val mapper = MapQuotedRateToTransactionsDao()

    @Test
    fun `should map QuotedRate to Transaction correctly`() {
        //  Given
        val quotedRate = QuotedRate(
            perUnitConversion = "1.5", totalAmountConversion = "150.0"
        )
        val expectedTransaction = Transaction(
            perUnitConversion = "1.5", total = "150.0"
        )

        // When
        val actualTransaction = mapper.invoke(quotedRate)

        // Then
        assertEquals(expectedTransaction, actualTransaction)
    }

    @Test
    fun `should map QuotedRate with different values to Transaction correctly`() {
        //  Given
        val quotedRate = QuotedRate(
            perUnitConversion = "2.0", totalAmountConversion = "200.0"
        )
        val expectedTransaction = Transaction(
            perUnitConversion = "2.0", total = "200.0"
        )

        // When
        val actualTransaction = mapper.invoke(quotedRate)

        // Then
        assertEquals(expectedTransaction, actualTransaction)
    }
}