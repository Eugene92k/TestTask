package com.egorovoy.testtask.di.modules

import com.egorovoy.testtask.data.local.dao.ItemDao
import com.egorovoy.testtask.data.mapper.Mapper
import com.egorovoy.testtask.data.repository.ItemRepositoryImpl
import com.egorovoy.testtask.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideItemRepository(itemDao: ItemDao, mapper: Mapper): ItemRepository {
        return ItemRepositoryImpl(itemDao, mapper)
    }
}