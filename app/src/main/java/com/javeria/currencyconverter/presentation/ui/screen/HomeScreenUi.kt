package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.R
import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.presentation.viewstate.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUi(
    modifier: Modifier = Modifier,
    uiState: UiState,
    baseCurrencySelected: (Currency) -> Unit = {},
    targetCurrencySelected: (Currency) -> Unit = {},
    convertButtonClicked: (String) -> Unit = {},
    approveConversion: (QuotedRate) -> Unit = {},
    recentTransactionsClicked: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Currency Converter")
                }
            )
        },
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            RequestStatusUi(requestStatusUiState = uiState.requestStatusUiState)
            Spacer(modifier = Modifier.padding(12.dp))
            HorizontalDivider()
            CurrencyCoverterUi(
                converterUiState = uiState.currencyConverterUiState,
                amount = uiState.amount,
                baseCurrencySelected = baseCurrencySelected,
                targetCurrencySelected = targetCurrencySelected,
                convertButtonClicked = { amount -> convertButtonClicked(amount) },
            )
        }
        QuotedRateUi(
            modifier = Modifier.fillMaxSize(),
            quotedConverterUiState = uiState.quotedState,
            approveConversion = approveConversion
        )
        HorizontalDivider()
        if (!uiState.approvedTransactions.isNullOrEmpty()) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                onClick = recentTransactionsClicked) {
                Text(stringResource(id = R.string.convert_button))
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenUi(
        modifier = Modifier,
        uiState = UiState(),
        baseCurrencySelected = {},
        targetCurrencySelected = {},
        convertButtonClicked = {})
}