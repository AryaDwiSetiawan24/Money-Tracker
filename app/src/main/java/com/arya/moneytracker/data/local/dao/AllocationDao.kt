package com.arya.moneytracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arya.moneytracker.data.local.entity.AllocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AllocationDao {

    @Insert
    suspend fun insert(
        allocation: AllocationEntity
    ): Long

    @Insert
    suspend fun insertAll(
        allocations: List<AllocationEntity>
    )

    @Query(
        """
        SELECT * FROM allocation
        WHERE incomeId = :incomeId
        ORDER BY id ASC
        """
    )
    suspend fun getByIncomeId(
        incomeId: Long
    ): List<AllocationEntity>

    @Query(
        """
        SELECT * FROM allocation
        ORDER BY createdAt DESC
        """
    )
    fun getAll(): Flow<List<AllocationEntity>>

    @Query(
        """
        SELECT * FROM allocation
        WHERE categoryId = :categoryId
        ORDER BY createdAt DESC
        """
    )
    fun getByCategoryId(
        categoryId: Long
    ): Flow<List<AllocationEntity>>
}