package com.egorovoy.testtask.di.modules

import com.egorovoy.testtask.domain.repository.ItemRepository
import com.egorovoy.testtask.domain.usecases.DeleteItemUseCase
import com.egorovoy.testtask.domain.usecases.GetAllItemsUseCase
import com.egorovoy.testtask.domain.usecases.GetItemByIdUseCase
import com.egorovoy.testtask.domain.usecases.InsertItemUseCase
import com.egorovoy.testtask.domain.usecases.SearchItemsByNameUseCase
import com.egorovoy.testtask.domain.usecases.UpdateItemAmountUseCase
import com.egorovoy.testtask.domain.usecases.UpdateItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideDeleteItemUseCase(itemRepository: ItemRepository): DeleteItemUseCase {
        return DeleteItemUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllItemsUseCase(itemRepository: ItemRepository): GetAllItemsUseCase {
        return GetAllItemsUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetItemByIdUseCase(itemRepository: ItemRepository): GetItemByIdUseCase {
        return GetItemByIdUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideInsertItemUseCase(itemRepository: ItemRepository): InsertItemUseCase {
        return InsertItemUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSearchItemsByNameUseCase(itemRepository: ItemRepository): SearchItemsByNameUseCase {
        return SearchItemsByNameUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdateItemAmountUseCase(itemRepository: ItemRepository): UpdateItemAmountUseCase {
        return UpdateItemAmountUseCase(itemRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdateItemUseCase(itemRepository: ItemRepository): UpdateItemUseCase {
        return UpdateItemUseCase(itemRepository)
    }
}