package com.example.weatherappsummer26.DataLayer.SearchDataLayer

class SearchRepo {

    suspend fun searchForCities(query : String): List<CityClass>{
        return CitiesAPIService.api.autoCompleteCity(query)
    }
}