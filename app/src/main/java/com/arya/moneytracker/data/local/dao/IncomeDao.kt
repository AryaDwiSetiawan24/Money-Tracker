package com.arya.moneytracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.arya.moneytracker.data.local.entity.IncomeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDao {

    @Insert
    suspend fun insert(
        income: IncomeEntity
    ): Long

    @Query(
        "SELECT * FROM income ORDER BY createdAt DESC"
    )
    fun getAll(): Flow<List<IncomeEntity>>

    @Query(
        "SELECT * FROM income WHERE id = :incomeId LIMIT 1"
    )
    suspend fun getById(
        incomeId: Long
    ): IncomeEntity?

    @Delete
    suspend fun delete(
        income: IncomeEntity
    )
}