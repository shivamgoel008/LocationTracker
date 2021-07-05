package com.example.googlemaps.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GoogleM::class], version = 1)
abstract class GoogleMDatabase : RoomDatabase() {

    abstract fun googleMListDao(): GoogleMListDao
    abstract fun gooleMDetailDao(): GoogleMDetailDao

    companion object {
        @Volatile
        private var instance: GoogleMDatabase? = null

        fun getDatabase(context: Context) = instance
            ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    GoogleMDatabase::class.java,
                    "googleM_database"
                ).build().also { instance = it }
            }
    }
}