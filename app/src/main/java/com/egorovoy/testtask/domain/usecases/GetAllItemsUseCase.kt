package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository

class GetAllItemsUseCase(
    private val repository: ItemRepository
) {
    operator fun invoke() = repository.getAllItems()
}