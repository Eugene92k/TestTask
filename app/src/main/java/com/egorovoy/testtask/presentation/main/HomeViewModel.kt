package com.egorovoy.testtask.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egorovoy.testtask.domain.model.Item
import com.egorovoy.testtask.domain.usecases.DeleteItemUseCase
import com.egorovoy.testtask.domain.usecases.GetAllItemsUseCase
import com.egorovoy.testtask.domain.usecases.InsertItemUseCase
import com.egorovoy.testtask.domain.usecases.SearchItemsByNameUseCase
import com.egorovoy.testtask.domain.usecases.UpdateItemAmountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllItemsUseCase: GetAllItemsUseCase,
    private val searchItemsByNameUseCase: SearchItemsByNameUseCase,
    private val insertItemUseCase: InsertItemUseCase,
    private val updateItemAmountUseCase: UpdateItemAmountUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        //TODO 1 метод вызывается, если из БД ничего не приходит, закомментировал
//        initializeDatabase()
        loadItems()
    }

    fun updateAmount(itemId: Int, amount: Int) {
        viewModelScope.launch {
            updateItemAmountUseCase(itemId, amount)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            deleteItemUseCase(item)
        }
    }

    private fun initializeDatabase() {
        viewModelScope.launch {
            if (getAllItemsUseCase().first().isEmpty()) {
                insertInitialData()
            }
        }
    }

    @OptIn(FlowPreview::class)
    private fun loadItems() {
        viewModelScope.launch {
            _searchQuery
//TODO 2 задержку поставил для наглядности (как-будто происходит какая-то долгая работа с поиском в БД)
//                .debounce(300)
                .collectLatest { query ->
                    if (query.isBlank()) {
                        getAllItemsUseCase().collect {
                            _items.value = it
                        }
                    } else {
                        searchItemsByNameUseCase(query).collect {
                            _items.value = it
                        }
                    }
                }
        }
    }


    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    private suspend fun insertInitialData() {
        val itemsToInsert = listOf(
            Item(id = 1, name = "iPhone 13", time = 1633046400000, tags = listOf("Телефон", "Новый", "Распродажа"), amount = 15),
            Item(id = 2, name = "Samsung Galaxy S21", time = 1633132800000, tags = listOf("Телефон", "Хит"), amount = 30),
            Item(id = 3, name = "PlayStation 5", time = 1633219200000, tags = listOf("Игровая приставка", "Акция", "Распродажа"), amount = 7),
            Item(id = 4, name = "LG OLED TV", time = 1633305600000, tags = listOf("Телевизор", "Эксклюзив", "Ограниченный"), amount = 22),
            Item(id = 5, name = "Apple Watch Series 7", time = 1633392000000, tags = listOf("Часы", "Новый", "Рекомендуем"), amount = 0),
            Item(id = 6, name = "Xiaomi Mi 11", time = 1633478400000, tags = listOf("Телефон", "Скидка", "Распродажа"), amount = 5,),
            Item(id = 7, name = "MacBook Air M1", time = 1633564800000, tags = listOf("Ноутбук", "Тренд"), amount = 12),
            Item(id = 8, name = "Amazon Kindle Paperwhite", time = 1633651200000, tags = listOf("Электронная книга", "Последний шанс", "Ограниченный"), amount = 18),
            Item(id = 9, name = "Fitbit Charge 5", time = 1633737600000, tags = emptyList(), amount = 27),
            Item(id = 10, name = "GoPro Hero 10", time = 1633824000000, tags = listOf("Камера", "Эксклюзив"), amount = 25)
        )
        itemsToInsert.forEach {
            insertItemUseCase(it)
        }
    }
}