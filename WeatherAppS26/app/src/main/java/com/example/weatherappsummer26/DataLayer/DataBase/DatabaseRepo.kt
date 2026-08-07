package com.example.weatherappsummer26.DataLayer.DataBase

class DatabaseRepo(val city_dao : CityDAO) {

    suspend fun addNewCity(city: City){
        city_dao.insertNewCity(city)
    }
    suspend fun getAllCities(): List<City>{
        return city_dao.getAllCities()
    }
    suspend fun searchForCities(q: String): List<City>{
        return city_dao.getAllCitiesStartWith(q)
    }
    suspend fun deleteOneCity(city: City){
        city_dao.deleteCity(city)
    }




}