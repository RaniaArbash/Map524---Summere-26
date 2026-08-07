package com.example.weatherappsummer26.DataLayer.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class City(
    @PrimaryKey (autoGenerate = true)
    val cityID: Int,

    @ColumnInfo("city_name")
    val name: String,
)