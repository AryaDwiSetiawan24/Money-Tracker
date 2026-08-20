package com.arya.moneytracker.util

import com.arya.moneytracker.data.model.AllocationCategory
import com.arya.moneytracker.data.model.AllocationResult

object AllocationEngine {

    fun allocate(
        income: Long,
        categories: List<AllocationCategory>
    ): List<AllocationResult> {

        require(income > 0) {
            "Income harus lebih besar dari 0"
        }

        require(categories.isNotEmpty()) {
            "Kategori tidak boleh kosong"
        }

        val totalPercentage = categories.sumOf {
            it.percentage
        }

        require(totalPercentage == 100) {
            "Total persentase harus 100%"
        }

        return categories.map { category ->

            val amount =
                income * category.percentage / 100

            AllocationResult(
                categoryName = category.name,
                percentage = category.percentage,
                amount = amount
            )
        }
    }
}