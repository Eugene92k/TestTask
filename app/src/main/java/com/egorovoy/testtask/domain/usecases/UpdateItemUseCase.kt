package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.model.Item
import com.egorovoy.testtask.domain.repository.ItemRepository
import javax.inject.Inject

class UpdateItemUseCase @Inject constructor (
    private val repository: ItemRepository
) {
    suspend operator fun invoke(item: Item) = repository.updateItem(item = item)
}