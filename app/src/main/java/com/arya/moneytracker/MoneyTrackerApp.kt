package com.arya.moneytracker

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arya.moneytracker.navigation.MoneyTrackerNavGraph
import com.arya.moneytracker.ui.theme.MoneyTrackerTheme

@Composable
fun MoneyTrackerApp() {
    MoneyTrackerTheme {

        val navController = rememberNavController()

        MoneyTrackerNavGraph(
            navController = navController
        )
    }
}