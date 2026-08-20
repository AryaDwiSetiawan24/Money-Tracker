package com.arya.moneytracker.ui.income

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arya.moneytracker.ui.income.components.AllocationResultCard
import com.arya.moneytracker.viewmodel.IncomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeScreen(
    onBackClick: () -> Unit,
    viewModel: IncomeViewModel = viewModel()
) {
    val income by viewModel.income.collectAsState()
    val incomeError by viewModel.incomeError.collectAsState()
    val allocationResults by viewModel.allocationResults.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tambah Income")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = income,
                onValueChange = {
                    viewModel.updateIncome(it)
                },
                label = {
                    Text("Jumlah income")
                },
                singleLine = true,
                isError = incomeError != null,
                supportingText = {
                    incomeError?.let {
                        Text(it)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    viewModel.allocateIncome()
                }
            ) {
                Text("Alokasikan")
            }

            if (allocationResults.isNotEmpty()) {

                Text(
                    text = "Hasil Alokasi"
                )

                allocationResults.forEach { result ->

                    AllocationResultCard(
                        result = result
                    )
                }
            }
        }
    }
}