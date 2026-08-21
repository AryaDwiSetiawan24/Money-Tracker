package com.arya.moneytracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arya.moneytracker.data.local.dao.AllocationDao
import com.arya.moneytracker.data.local.dao.CategoryDao
import com.arya.moneytracker.data.local.dao.IncomeDao
import com.arya.moneytracker.data.local.entity.AllocationEntity
import com.arya.moneytracker.data.local.entity.CategoryEntity
import com.arya.moneytracker.data.local.entity.IncomeEntity

@Database(
    entities = [
        IncomeEntity::class,
        CategoryEntity::class,
        AllocationEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class MoneyTrackerDatabase : RoomDatabase() {

    abstract fun incomeDao(): IncomeDao

    abstract fun categoryDao(): CategoryDao

    abstract fun allocationDao(): AllocationDao
}