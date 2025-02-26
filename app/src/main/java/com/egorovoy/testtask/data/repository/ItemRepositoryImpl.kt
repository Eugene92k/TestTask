package com.egorovoy.testtask.data.repository

import com.egorovoy.testtask.data.local.dao.ItemDao
import com.egorovoy.testtask.data.mapper.Mapper
import com.egorovoy.testtask.domain.model.Item
import com.egorovoy.testtask.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemRepositoryImpl(private val itemDao: ItemDao, private val mapper: Mapper) :
    ItemRepository {

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(mapper.map(item))
    }

    override suspend fun updateItem(item: Item) {
        itemDao.updateItem(mapper.map(item))
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(mapper.map(item))
    }

    override fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems().map { itemEntities ->
            itemEntities.map { mapper.map(it) }
        }
    }

    override fun searchItemsByName(query: String): Flow<List<Item>> {
        return itemDao.searchItemsByName(query).map { itemEntities ->
            itemEntities.map { mapper.map(it) }
        }
    }

    override fun getItemById(itemId: Int): Flow<Item?> {
        return itemDao.getItemById(itemId).map { itemEntity ->
            itemEntity?.let { mapper.map(it) }
        }
    }

    override suspend fun updateItemAmount(itemId: Int, amount: Int) {
        itemDao.updateItemAmount(itemId, amount)
    }
}