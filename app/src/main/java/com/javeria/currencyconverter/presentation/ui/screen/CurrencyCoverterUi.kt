package com.javeria.currencyconverter.presentation.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.R
import com.javeria.currencyconverter.data.local.model.Currency
import com.javeria.currencyconverter.presentation.state.CurrencyConverterUiState

@Composable
fun CurrencyCoverterUi(
    converterUiState: CurrencyConverterUiState,
    amount: String,
    baseCurrencySelected: (String) -> Unit,
    targetCurrencySelected: (String) -> Unit,
    convertButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(12.dp)) {
        Text(
            text = stringResource(id = R.string.amount_heading),
            style = MaterialTheme.typography.titleLarge
        )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            value = amount,
            onValueChange = {
                amount //TODO: Change this
            },
            label = { Text(text = stringResource(id = R.string.amount_label)) })
        when (converterUiState) {
            CurrencyConverterUiState.Error -> {
                GenericErrorUi()
            }

            is CurrencyConverterUiState.Loading -> {
                CircularProgressIndicator(
                    Modifier
                        .padding(8.dp)
                        .height(12.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            is CurrencyConverterUiState.CurrencyListSuccess -> {
                if (converterUiState.currencyList.isNullOrEmpty()) {
                    Toast.makeText(
                        LocalContext.current,
                        stringResource(id = R.string.currency_list_unavailable),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    DropdownUi(selectedValue = "",
                        currency = converterUiState.currencyList,
                        label = stringResource(id = R.string.base_currency),
                        onValueChangedEvent = {})
                    DropdownUi(selectedValue = "",
                        currency = converterUiState.currencyList,
                        label = stringResource(id = R.string.target_currency),
                        onValueChangedEvent = {})
                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), onClick = { }) {
                        Text(stringResource(id = R.string.approve_button))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyCoverterUiPreview() {
    CurrencyCoverterUi(
        CurrencyConverterUiState.CurrencyListSuccess(
            listOf(
                Currency(
                    "£",
                    "British Sterling Pounds",
                    "GBP"
                )
            )
        ), "", {}, {}, {})
}