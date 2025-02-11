package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.data.local.model.Currency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownUi(
    selectedValue: String,
    currency: List<Currency>,
    label: String,
    onValueChangedEvent: (Currency) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var textVal by remember { mutableStateOf(selectedValue) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        OutlinedTextField(
            readOnly = true,
            value = textVal,
            onValueChange = {},
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = OutlinedTextFieldDefaults.colors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            currency.forEach { currency: Currency ->
                DropdownMenuItem(
                    text = { Text(text = "${currency.symbol} ${currency.name} (${currency.code})") },
                    onClick = {
                        textVal = "${currency.symbol} ${currency.name} (${currency.code})"
                        expanded = false
                        onValueChangedEvent(currency)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownUiPreview() {
    DropdownUi(selectedValue = "GBP",
        currency = listOf(),
        label = "Base currency",
        onValueChangedEvent = {})
}