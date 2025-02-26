package com.egorovoy.testtask.data.mapper

import com.egorovoy.testtask.data.local.entity.ItemEntity
import com.egorovoy.testtask.domain.model.Item

class Mapper {
    fun map(itemEntity: ItemEntity): Item {
        return Item(
            id = itemEntity.id,
            name = itemEntity.name,
            time = itemEntity.time,
            tags = itemEntity.tags,
            amount = itemEntity.amount
        )
    }

    fun map(item: Item): ItemEntity {
        return ItemEntity(
            id = item.id,
            name = item.name,
            time = item.time,
            tags = item.tags,
            amount = item.amount
        )
    }
}