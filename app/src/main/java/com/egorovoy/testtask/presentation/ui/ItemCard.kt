package com.egorovoy.testtask.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egorovoy.testtask.domain.model.Item

@Composable
fun ItemCard(
    itemName: String,
    itemAvailability: String,
    itemDateAdded: String,
    itemId: Int,
    tags: List<String> = emptyList(),
    onAmountChanged: (Int, Int) -> Unit,
    onDeleteItem: (Item) -> Unit
) {
    var isEditDialogOpen by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = itemName,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "texttext",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "На складе",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = itemAvailability,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Дата добавления",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = itemDateAdded,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
            if (tags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    tags.forEach { tag ->
                        // TODO:
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { isEditDialogOpen = true }
                ) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Редактировать")
                }
                IconButton(
                    onClick = {
                        onDeleteItem(
                            Item(
                                id = itemId,
                                name = itemName,
                                amount = itemAvailability.toIntOrNull() ?: 0,
                                time = 0,
                                tags = tags
                            )
                        )
                    }
                ) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
    if (isEditDialogOpen) {
        EditAmountDialog(
            currentAmount = itemAvailability.toIntOrNull() ?: 0,
            itemId = itemId,
            onAmountChanged = onAmountChanged,
            onDismiss = { isEditDialogOpen = false }
        )
    }
}