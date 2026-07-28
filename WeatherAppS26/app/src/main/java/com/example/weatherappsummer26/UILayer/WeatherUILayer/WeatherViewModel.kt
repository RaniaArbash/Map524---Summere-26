package com.example.weatherappsummer26.UILayer.WeatherUILayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappsummer26.DataLayer.WeatherDataLayer.WeatherRepo
import com.example.weatherappsummer26.DataLayer.WeatherDataLayer.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    val weatherRepo = WeatherRepo()
    val _weatherState= MutableStateFlow<WeatherResponse?>(null)
    val weatherState : MutableStateFlow<WeatherResponse?> = _weatherState
    fun loadWeather(cityName: String){
        // go to repository to get the weather
        viewModelScope.launch {
            _weatherState.value =  weatherRepo.getWeatherFromAPIByCityName(cityName)
            // this will take time, so keep it
            // in background thread

        }

    }



}