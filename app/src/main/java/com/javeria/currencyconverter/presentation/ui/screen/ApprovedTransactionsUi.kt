package com.javeria.currencyconverter.presentation.ui.screen

import android.widget.Toast
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.javeria.currencyconverter.R
import com.javeria.currencyconverter.presentation.viewstate.ApprovedTransactionsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApprovedTransactionsUi(
    onDismiss: () -> Unit,
    approvedTransactions: ApprovedTransactionsState
) {
    when (approvedTransactions) {
        is ApprovedTransactionsState.Content -> {
            val modalBottomSheetState = rememberModalBottomSheetState()
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = modalBottomSheetState,
                dragHandle = { BottomSheetDefaults.DragHandle() },
            ) {
                ApprovedTransactionsList(approvedTransactions = approvedTransactions.list)
            }
        }

        ApprovedTransactionsState.NoData -> {
            Toast.makeText(LocalContext.current, stringResource(id = R.string.no_recent_transactions), Toast.LENGTH_SHORT).show()
        }
    }

}