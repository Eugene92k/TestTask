package com.egorovoy.testtask.domain.usecases

import com.egorovoy.testtask.domain.repository.ItemRepository

class SearchItemsByNameUseCase(
    private val repository: ItemRepository
) {

    operator fun invoke(query: String) = repository.searchItemsByName(query = query)
}