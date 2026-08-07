package com.example.weatherappsummer26.DataLayer.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  CityDAO {

    @Query("SELECT * FROM City")
    suspend fun getAllCities() : List<City>

    //get all cities start with one letter

    @Query("select * from city where city_name LIKE :letter || '%'")
    suspend fun getAllCitiesStartWith(letter: String): List<City>

    @Insert
    suspend fun insertNewCity(newCity : City)


    @Delete
    suspend fun deleteCity (cityToDelete: City)


    @Query("delete from City where city_name LIKE :name")
    suspend fun deleteOneCity(name: String)



}