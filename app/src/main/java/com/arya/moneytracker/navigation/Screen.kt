package com.arya.moneytracker.navigation

sealed class Screen(
    val route: String
) {
    data object Dashboard : Screen("dashboard")
    data object Income : Screen("income")
}