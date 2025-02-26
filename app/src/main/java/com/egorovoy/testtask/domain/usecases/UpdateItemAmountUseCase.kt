package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository
import javax.inject.Inject

class UpdateItemAmountUseCase @Inject constructor (
    private val repository: ItemRepository
) {

    suspend operator fun invoke(itemId: Int, amount: Int) = repository.updateItemAmount(itemId, amount)
}