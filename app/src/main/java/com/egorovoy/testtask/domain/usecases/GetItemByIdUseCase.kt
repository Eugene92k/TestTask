package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository

class GetItemByIdUseCase(
    private val repository: ItemRepository
) {

    suspend operator fun invoke(itemId: Int) = repository.getItemById(itemId = itemId)
}