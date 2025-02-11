package com.javeria.currencyconverter.presentation.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.R
import com.javeria.currencyconverter.data.local.model.QuotedRate
import com.javeria.currencyconverter.presentation.viewstate.QuotedConverterUiState

@Composable
fun QuotedRateUi(
    quotedConverterUiState: QuotedConverterUiState?,
    approveConversion: (QuotedRate) -> Unit,
    modifier: Modifier = Modifier
) {

    when (quotedConverterUiState) {
        QuotedConverterUiState.Error -> {
            Toast.makeText(LocalContext.current, "Something went wrong", Toast.LENGTH_SHORT).show()
        }

        QuotedConverterUiState.Loading -> {
            CircularProgressIndicator(
                modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .height(12.dp)
            )
        }

        is QuotedConverterUiState.QuotedRateSuccess -> {

            val openDialog = remember { mutableStateOf(quotedConverterUiState.showDialog) }
            Column {
                if (openDialog.value) {
                    AlertDialog(onDismissRequest = { openDialog.value = false },
                        title = {
                            Text(
                                text = stringResource(id = R.string.latest_exchange_heading),
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        text = {
                            Text(
                                "${quotedConverterUiState.quotedRate?.perUnitConversion}" +
                                        "\n${quotedConverterUiState.quotedRate?.totalAmountConversion}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        confirmButton = {
                            Button(onClick = {
                                quotedConverterUiState.quotedRate?.let {
                                    approveConversion(it)

                                }
                                openDialog.value = false
                            }) {
                                Text(stringResource(id = R.string.approve))
                            }
                        },
                        dismissButton = {
                            Button(onClick = {
                                openDialog.value = false
                            }) {
                                Text(stringResource(id = R.string.deny))
                            }
                        })
                }
            }
        }

        else -> {

        }
    }
}