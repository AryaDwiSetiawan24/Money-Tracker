package com.arya.moneytracker.util

import java.text.NumberFormat
import java.util.Locale

fun formatRupiah(amount: Long): String {
    val formatter = NumberFormat.getNumberInstance(
        Locale("id", "ID")
    )

    return "Rp ${formatter.format(amount)}"
}