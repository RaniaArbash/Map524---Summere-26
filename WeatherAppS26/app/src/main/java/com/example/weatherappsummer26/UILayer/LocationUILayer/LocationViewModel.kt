package com.example.weatherappsummer26.UILayer.LocationUILayer

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappsummer26.DataLayer.LocationDataLayer.LocationService
import com.example.weatherappsummer26.DataLayer.WeatherDataLayer.WeatherRepo
import com.example.weatherappsummer26.DataLayer.WeatherDataLayer.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationViewModel(application: Application):AndroidViewModel(application) {

    val weatherRepo = WeatherRepo()

    private val _currentLocation = MutableStateFlow<Location?>(null)
    val currentLocation : StateFlow<Location?> = _currentLocation
    var locationService = LocationService(application)

    val _weatherState= MutableStateFlow<WeatherResponse?>(null)
    val weatherState : MutableStateFlow<WeatherResponse?> = _weatherState
    fun loadWeather(lon: Double, lat: Double){
        // go to repository to get the weather
        viewModelScope.launch {
            _weatherState.value =  weatherRepo.getWeatherFromAPIByLocation(lat,lon)
        }
    }

    fun fetchCurrentLocation(){
        viewModelScope.launch{
            _currentLocation.value = locationService.getCurrentLocation()
        }
    }




}