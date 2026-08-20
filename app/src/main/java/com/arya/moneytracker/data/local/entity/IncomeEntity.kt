package com.arya.moneytracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income")
data class IncomeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val amount: Long,

    val createdAt: Long
)