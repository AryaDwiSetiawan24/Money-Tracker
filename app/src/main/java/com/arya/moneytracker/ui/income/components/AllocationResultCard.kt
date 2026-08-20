package com.arya.moneytracker.ui.income.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arya.moneytracker.data.model.AllocationResult
import com.arya.moneytracker.util.formatRupiah

@Composable
fun AllocationResultCard(
    result: AllocationResult,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = result.categoryName,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = formatRupiah(result.amount),
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "${result.percentage}%",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}