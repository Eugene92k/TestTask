package com.egorovoy.testtask.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.egorovoy.testtask.data.local.dao.ItemDao
import com.egorovoy.testtask.data.local.entity.ItemEntity

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}