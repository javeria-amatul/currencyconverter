package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.presentation.state.HomeUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUi(
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState
) {
    Scaffold(modifier = modifier,
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
            RequestStatusUi(requestStatusUiState = homeUiState.requestStatusUiState)
            Spacer(modifier = Modifier.padding(12.dp))
            HorizontalDivider()
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenUi(Modifier, HomeUiState())
}