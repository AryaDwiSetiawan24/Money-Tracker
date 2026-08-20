package com.arya.moneytracker.viewmodel

import androidx.lifecycle.ViewModel
import com.arya.moneytracker.data.model.AllocationResult
import com.arya.moneytracker.data.model.defaultCategories
import com.arya.moneytracker.util.AllocationEngine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class IncomeViewModel : ViewModel() {

    private val _income = MutableStateFlow("")
    val income: StateFlow<String> = _income.asStateFlow()

    private val _incomeError = MutableStateFlow<String?>(null)
    val incomeError: StateFlow<String?> = _incomeError.asStateFlow()

    private val _allocationResults =
        MutableStateFlow<List<AllocationResult>>(emptyList())

    val allocationResults: StateFlow<List<AllocationResult>> =
        _allocationResults.asStateFlow()

    fun updateIncome(value: String) {

        if (value.all { it.isDigit() }) {
            _income.value = value
            _incomeError.value = null
            _allocationResults.value = emptyList()
        }
    }

    fun allocateIncome() {

        val incomeAmount = _income.value.toLongOrNull()

        if (incomeAmount == null || incomeAmount <= 0) {
            _incomeError.value = "Masukkan jumlah income yang valid"
            return
        }

        _incomeError.value = null

        _allocationResults.value =
            AllocationEngine.allocate(
                income = incomeAmount,
                categories = defaultCategories
            )
    }
}