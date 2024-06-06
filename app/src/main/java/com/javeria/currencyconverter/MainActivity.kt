package com.javeria.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.javeria.currencyconverter.presentation.CurrencyConverterEvent
import com.javeria.currencyconverter.presentation.state.MainViewModel
import com.javeria.currencyconverter.presentation.ui.screen.HomeScreenUi
import com.javeria.currencyconverter.presentation.ui.theme.CurrencyConverterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle(lifecycleOwner = androidx.compose.ui.platform.LocalLifecycleOwner.current)
            CurrencyConverterTheme {
                HomeScreenUi(uiState = uiState,
                    baseCurrencySelected = {
                        viewModel.dispatch(
                            CurrencyConverterEvent.BaseCurrencySelected(
                                it
                            )
                        )
                    },
                    targetCurrencySelected = {
                        viewModel.dispatch(
                            CurrencyConverterEvent.TargetCurrencySelected(
                                it
                            )
                        )
                    },
                    convertButtonClicked = {
                        viewModel.dispatch(
                            CurrencyConverterEvent.ConvertCurrencyClicked(
                                it
                            )
                        )
                    })
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CurrencyConverterTheme {
        Greeting("Android")
    }
}