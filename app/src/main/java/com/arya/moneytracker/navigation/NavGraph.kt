package com.arya.moneytracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arya.moneytracker.ui.dashboard.DashboardScreen
import com.arya.moneytracker.ui.income.IncomeScreen

@Composable
fun MoneyTrackerNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(
            route = Screen.Dashboard.route
        ) {
            DashboardScreen(
                onAddIncomeClick = {
                    navController.navigate(Screen.Income.route)
                }
            )
        }

        composable(
            route = Screen.Income.route
        ) {
            IncomeScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}