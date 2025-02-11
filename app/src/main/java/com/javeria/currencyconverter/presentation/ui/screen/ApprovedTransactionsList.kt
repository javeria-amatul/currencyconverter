package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.data.local.model.QuotedRate


@Composable
fun ApprovedTransactionsList(
    modifier: Modifier = Modifier,
    approvedTransactions: List<QuotedRate>
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(approvedTransactions) { approvedTransaction ->
            ApprovedTransactionItem(quotedRate = approvedTransaction)
        }
    }
}


@Composable
fun ApprovedTransactionItem(quotedRate: QuotedRate, modifier: Modifier = Modifier) {
    Row(modifier.padding(12.dp)) {
        Column {
            Text(text = quotedRate.perUnitConversion)
            Text(text = quotedRate.totalAmountConversion)
            HorizontalDivider()
        }
    }
}