package com.egorovoy.testtask.di.modules

import android.app.Application
import androidx.room.Room
import com.egorovoy.testtask.data.local.dao.ItemDao
import com.egorovoy.testtask.data.local.db.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideItemDatabase(application: Application): ItemDatabase {
        return Room.databaseBuilder(
            application,
            ItemDatabase::class.java,
            "item_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideItemDao(database: ItemDatabase): ItemDao {
        return database.itemDao()
    }
}