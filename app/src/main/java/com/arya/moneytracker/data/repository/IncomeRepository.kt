package com.arya.moneytracker.data.repository

import com.arya.moneytracker.data.local.dao.IncomeDao
import com.arya.moneytracker.data.local.entity.IncomeEntity
import kotlinx.coroutines.flow.Flow

class IncomeRepository(
    private val incomeDao: IncomeDao
) {

    suspend fun insertIncome(
        amount: Long,
        createdAt: Long
    ): Long {

        val income = IncomeEntity(
            amount = amount,
            createdAt = createdAt
        )

        return incomeDao.insert(income)
    }

    fun getAllIncome(): Flow<List<IncomeEntity>> {
        return incomeDao.getAll()
    }

    suspend fun getIncomeById(
        incomeId: Long
    ): IncomeEntity? {
        return incomeDao.getById(incomeId)
    }

    suspend fun deleteIncome(
        income: IncomeEntity
    ) {
        incomeDao.delete(income)
    }
}