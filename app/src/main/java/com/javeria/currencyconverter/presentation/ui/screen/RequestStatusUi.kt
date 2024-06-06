package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeria.currencyconverter.R
import com.javeria.currencyconverter.data.local.model.RequestStatus
import com.javeria.currencyconverter.presentation.state.RequestStatusUiState


@Composable
fun RequestStatusUi(modifier: Modifier = Modifier, requestStatusUiState: RequestStatusUiState) {

    Surface(
        modifier = modifier.fillMaxWidth().padding(18.dp), shape = MaterialTheme.shapes.small
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                text = stringResource(id = R.string.request_status_heading),
                textAlign = TextAlign.Center
            )
            when (requestStatusUiState) {
                RequestStatusUiState.Loading -> {
                    CircularProgressIndicator(
                        Modifier
                            .padding(8.dp)
                            .height(12.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                is RequestStatusUiState.RequestStatusContent -> {
                    RequestStatusSuccessUI(requestStatus = (requestStatusUiState.requestStatus))
                }

                RequestStatusUiState.Error -> {
                    GenericErrorUi()
                }
            }
        }
    }
}

@Composable
private fun RequestStatusSuccessUI(requestStatus: RequestStatus) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.SpaceEvenly
    ) {
        ApiStatusCell(
            status = stringResource(id = R.string.remaining), requestStatus.remaining
        )
        ApiStatusCell(status = stringResource(id = R.string.used), requestStatus.used)
        ApiStatusCell(
            status = stringResource(id = R.string.total), requestStatus.total
        )
    }
}

@Composable
private fun ApiStatusCell(status: String, requestCount: Int) {
    Column {
        Text(text = status, style = MaterialTheme.typography.titleMedium)
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = requestCount.toString(),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RequestStatusUIPreview() {
    RequestStatusUi(
        requestStatusUiState = RequestStatusUiState.RequestStatusContent(
            RequestStatus(
                1,
                2,
                3
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ApiStatusCellPreview() {
    ApiStatusCell(status = "Total", 1)
}

