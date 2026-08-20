package com.arya.moneytracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "allocation",
    foreignKeys = [
        ForeignKey(
            entity = IncomeEntity::class,
            parentColumns = ["id"],
            childColumns = ["incomeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index(value = ["incomeId"]),
        Index(value = ["categoryId"])
    ]
)
data class AllocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val incomeId: Long,
    val categoryId: Long,

    val categoryNameSnapshot: String,
    val categoryPercentageSnapshot: Int,

    val allocationAmount: Long,

    val createdAt: Long
)