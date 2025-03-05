package com.egorovoy.testtask.presentation.ui

import TagRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egorovoy.testtask.R
import com.egorovoy.testtask.domain.model.Item

@Composable
fun ItemCard(
    item: Item,
    itemId: Int,
    tags: List<String> = emptyList(),
    onAmountChanged: (Int, Int) -> Unit,
    onDeleteItem: (Item) -> Unit
) {
    var isEditDialogOpen by remember { mutableStateOf(false) }
    var isDeleteDialogOpen by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            //title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                //buttons
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    IconButton(
                        onClick = {
                            isEditDialogOpen = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = stringResource(R.string.item_card_edit_button),
                            tint = MaterialTheme.colorScheme.surfaceTint
                        )
                    }
                    IconButton(
                        onClick = {
                            isDeleteDialogOpen = true
                        },
                        modifier = Modifier.requiredWidth(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = stringResource(R.string.item_card_delete_button),
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }

            //tags chips
            if (tags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    TagRow(tags = tags)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))


            //на складе, дата добавления
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.item_card_availability_label),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = item.amount.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = stringResource(R.string.item_card_date_added_label),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = formatDate(item.time),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }

        }
    }

    if (isEditDialogOpen) {
        EditAmountDialog(
            currentAmount = item.amount,
            itemId = itemId,
            onAmountChanged = onAmountChanged,
            onDismiss = { isEditDialogOpen = false }
        )
    }

    if (isDeleteDialogOpen) {
        DeleteItemConfirmationDialog(
            onConfirm = {
                onDeleteItem(
                    Item(
                        id = itemId,
                        name = item.name,
                        amount = item.amount,
                        time = 0,
                        tags = tags
                    )
                )
                isDeleteDialogOpen = false
            },
            onDismiss = {
                isDeleteDialogOpen = false
            }
        )
    }
}