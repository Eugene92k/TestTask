package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.model.Item
import com.egorovoy.testtask.domain.repository.ItemRepository

class InsertItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(item: Item) = repository.insertItem(item = item)
}