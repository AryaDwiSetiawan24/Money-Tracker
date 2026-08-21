package com.arya.moneytracker

import android.app.Application
import com.arya.moneytracker.data.local.DatabaseProvider
import com.arya.moneytracker.data.local.MoneyTrackerDatabase

class MoneyTrackerApplication : Application() {

    val database: MoneyTrackerDatabase by lazy {
        DatabaseProvider.getDatabase(this)
    }
}