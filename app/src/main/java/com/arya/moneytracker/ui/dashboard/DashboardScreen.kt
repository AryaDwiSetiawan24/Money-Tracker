package com.arya.moneytracker.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arya.moneytracker.ui.dashboard.components.CategoryCard

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    onAddIncomeClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddIncomeClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah income"
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {

            Text(
                text = "Money Tracker",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Total Balance",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Rp 18.000.000",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            CategoryCard(
                title = "Investasi",
                amount = "Rp 8.000.000"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            CategoryCard(
                title = "Dana Darurat",
                amount = "Rp 5.000.000"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            CategoryCard(
                title = "Kebutuhan",
                amount = "Rp 3.000.000"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            CategoryCard(
                title = "Hiburan",
                amount = "Rp 2.000.000"
            )
        }
    }
}