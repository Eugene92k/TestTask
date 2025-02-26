package com.egorovoy.testtask.domain.model

data class Item(
    val id: Int,
    val name: String,
    val time: Int,
    val tags: String,
    val amount: Int
)