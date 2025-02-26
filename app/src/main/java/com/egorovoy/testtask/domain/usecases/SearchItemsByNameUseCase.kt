package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository
import javax.inject.Inject

class SearchItemsByNameUseCase @Inject constructor (
    private val repository: ItemRepository
) {

    operator fun invoke(query: String) = repository.searchItemsByName(query = query)
}