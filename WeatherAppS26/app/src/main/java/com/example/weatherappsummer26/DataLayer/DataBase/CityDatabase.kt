package com.example.weatherappsummer26.DataLayer.DataBase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [City::class])
abstract class CityDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDAO

    companion object {
        @Volatile
        private var INSTANCE : CityDatabase? = null
        fun getDB(context: Application): CityDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CityDatabase::class.java,
                    "citiesDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}
