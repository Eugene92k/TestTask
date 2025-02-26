package com.egorovoy.testtask.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.egorovoy.testtask.R

@Composable
fun EditAmountDialog(
    currentAmount: Int,
    itemId: Int,
    onAmountChanged: (Int, Int) -> Unit,
    onDismiss: () -> Unit
) {
    var amount by remember { mutableIntStateOf(currentAmount) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.edit_amount_dialog_title)) },
        text = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { amount-- }) {
                        Text(stringResource(R.string.edit_amount_dialog_button_decrease))
                    }
                    Text(
                        text = amount.toString(),
                        modifier = Modifier.width(48.dp),
                        textAlign = TextAlign.Center
                    )
                    IconButton(onClick = { amount++ }) {
                        Text(stringResource(R.string.edit_amount_dialog_button_increase))
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onAmountChanged(itemId, amount)
                onDismiss()
            }) {
                Text(stringResource(R.string.edit_amount_dialog_button_ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.edit_amount_dialog_button_cancel))
            }
        }
    )
}