package com.javeria.currencyconverter.presentation.ui.screen

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.javeria.currencyconverter.data.local.model.QuotedRate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentTransactionsBottomSheet(onDismiss: () -> Unit, approvedTransactions: List<QuotedRate>) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        ApprovedTransactionsList(approvedTransactions = approvedTransactions)
    }
}