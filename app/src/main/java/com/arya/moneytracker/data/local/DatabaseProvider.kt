package com.arya.moneytracker.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var INSTANCE: MoneyTrackerDatabase? = null

    fun getDatabase(
        context: Context
    ): MoneyTrackerDatabase {

        return INSTANCE ?: synchronized(this) {

            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                MoneyTrackerDatabase::class.java,
                "money_tracker_database"
            )
                .build()
                .also {
                    INSTANCE = it
                }
        }
    }
}