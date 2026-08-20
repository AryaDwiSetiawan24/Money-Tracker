package com.arya.moneytracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.arya.moneytracker.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert
    suspend fun insert(
        category: CategoryEntity
    ): Long

    @Insert
    suspend fun insertAll(
        categories: List<CategoryEntity>
    )

    @Query(
        "SELECT * FROM category ORDER BY id ASC"
    )
    fun getAll(): Flow<List<CategoryEntity>>

    @Query(
        "SELECT * FROM category WHERE id = :categoryId LIMIT 1"
    )
    suspend fun getById(
        categoryId: Long
    ): CategoryEntity?

    @Update
    suspend fun update(
        category: CategoryEntity
    )

    @Delete
    suspend fun delete(
        category: CategoryEntity
    )
}