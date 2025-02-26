package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository
import javax.inject.Inject

class GetAllItemsUseCase @Inject constructor (
    private val repository: ItemRepository
) {
    operator fun invoke() = repository.getAllItems()
}