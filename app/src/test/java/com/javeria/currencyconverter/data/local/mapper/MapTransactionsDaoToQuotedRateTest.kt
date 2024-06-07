package com.javeria.currencyconverter.data.local.mapper

import com.javeria.currencyconverter.data.local.Transaction
import com.javeria.currencyconverter.data.local.model.QuotedRate
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MapTransactionsDaoToQuotedRateTest {

    private val mapper = MapTransactionsDaoToQuotedRate()

    @Test
    fun `should map Transaction to QuotedRate correctly`() {
        // Given
        val transaction = Transaction(
            perUnitConversion = "1.5",
            total = "150.0"
        )
        val expectedQuotedRate = QuotedRate(
            perUnitConversion = "1.5",
            totalAmountConversion = "150.0"
        )

        // When
        val actualQuotedRate = mapper.invoke(transaction)

        // Then
        assertEquals(expectedQuotedRate, actualQuotedRate)
    }

    @Test
    fun `should handle null values in Transaction`() {
        // Given
        val transaction = Transaction(
            perUnitConversion = null,
            total = null
        )
        val expectedQuotedRate = QuotedRate(
            perUnitConversion = "",
            totalAmountConversion = ""
        )

        // When
        val actualQuotedRate = mapper.invoke(transaction)

        // Then
        assertEquals(expectedQuotedRate, actualQuotedRate)
    }

    @Test
    fun `should map Transaction with some null values to QuotedRate correctly`() {
        // Given
        val transaction = Transaction(
            perUnitConversion = "2.0",
            total = null
        )
        val expectedQuotedRate = QuotedRate(
            perUnitConversion = "2.0",
            totalAmountConversion = ""
        )

        // When
        val actualQuotedRate = mapper.invoke(transaction)

        // Then
        assertEquals(expectedQuotedRate, actualQuotedRate)
    }

    @Test
    fun `should map Transaction with other null values to QuotedRate correctly`() {
        // Given
        val transaction = Transaction(
            perUnitConversion = null,
            total = "200.0"
        )
        val expectedQuotedRate = QuotedRate(
            perUnitConversion = "",
            totalAmountConversion = "200.0"
        )

        // When
        val actualQuotedRate = mapper.invoke(transaction)

        // Then
        assertEquals(expectedQuotedRate, actualQuotedRate)
    }
}
