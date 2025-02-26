package com.egorovoy.testtask.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.egorovoy.testtask.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Update
    suspend fun updateItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)

    @Query("SELECT * FROM item")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE name LIKE '%' || :query || '%'")
    fun searchItemsByName(query: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE id = :itemId")
    fun getItemById(itemId: Int): Flow<ItemEntity?>

    @Query("UPDATE item SET amount = :amount WHERE id = :itemId")
    suspend fun updateItemAmount(itemId: Int, amount: Int)
}