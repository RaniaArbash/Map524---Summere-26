package com.example.weatherappsummer26.UILayer.FavCities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappsummer26.DataLayer.DataBase.City
import com.example.weatherappsummer26.DataLayer.DataBase.CityDatabase
import com.example.weatherappsummer26.DataLayer.DataBase.DatabaseRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FavCitiesViewModel(application: Application):
    AndroidViewModel(application) {

    private val repository : DatabaseRepo
    init {
        val dao = CityDatabase.getDB(application).cityDao()
        repository = DatabaseRepo(dao)
    }

    private var _favoritesCities = MutableStateFlow<List<City>?>(emptyList())
    val favoritesCities: MutableStateFlow<List<City>??> = _favoritesCities



    fun getAllSavedCities() {
        viewModelScope.launch {
            _favoritesCities.value =
                repository.getAllCities() as List<City>? //.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
        }
    }

    fun deleteCity(city: City) {
        viewModelScope.launch {
            repository.deleteOneCity(city)
        }
    }

    fun searchForCIty(text: String) {
        viewModelScope.launch {
            _favoritesCities.value = repository.searchForCities(text)
        }
    }


    fun addNewCity(name: String) {
        viewModelScope.launch {
            repository.addNewCity(City(0, name))
        }
    }



}