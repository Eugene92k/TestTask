package com.egorovoy.testtask.domain.model

data class Item (
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int,
)