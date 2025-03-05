package com.egorovoy.testtask.domain.repository

import com.egorovoy.testtask.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun insertItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(item: Item)
    fun getAllItems(): Flow<List<Item>>
    fun searchItemsByName(query: String): Flow<List<Item>>
    fun getItemById(itemId: Int): Flow<Item?>
    suspend fun updateItemAmount(itemId: Int, amount: Int)
}