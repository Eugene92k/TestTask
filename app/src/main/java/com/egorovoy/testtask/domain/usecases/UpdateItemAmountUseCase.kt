package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.model.Item
import com.egorovoy.testtask.domain.repository.ItemRepository

class UpdateItemAmountUseCase(
    private val repository: ItemRepository
) {

    suspend operator fun invoke(item: Item) = repository.updateItem(item)
}