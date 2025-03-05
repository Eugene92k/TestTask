package com.egorovoy.testtask.data.mapper

import com.egorovoy.testtask.data.local.entity.ItemEntity
import com.egorovoy.testtask.domain.model.Item
import com.google.gson.Gson
import javax.inject.Inject

class Mapper @Inject constructor(
    private val gson: Gson
) {
    fun map(itemEntity: ItemEntity): Item {
        val tagsList: List<String> = fromJsonToList(itemEntity.tags) ?: emptyList()
        return Item(
            id = itemEntity.id,
            name = itemEntity.name,
            time = itemEntity.time,
            tags = tagsList,
            amount = itemEntity.amount,
        )
    }

    fun map(item: Item): ItemEntity {
        val tagsJsonString: String = toJsonFromList(item.tags) ?: "[]"
        return ItemEntity(
            id = item.id,
            name = item.name,
            time = item.time,
            tags = tagsJsonString,
            amount = item.amount,
        )
    }

    private fun fromJsonToList(jsonString: String?): List<String>? {
        return try {
            if (jsonString.isNullOrEmpty()) {
                emptyList()
            } else {
                val listType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                gson.fromJson(jsonString, listType)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun toJsonFromList(tagsList: List<String>?): String? {
        return try {
            gson.toJson(tagsList)
        } catch (e: Exception) {
            e.printStackTrace()
            "[]"
        }
    }
}