package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor (
    private val repository: ItemRepository
) {

    operator fun invoke(itemId: Int) = repository.getItemById(itemId = itemId)
}