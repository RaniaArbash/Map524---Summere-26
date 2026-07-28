package com.example.weatherappsummer26.DataLayer.WeatherDataLayer

class WeatherRepo {

    suspend fun getWeatherFromAPIByCityName(cityName : String ): WeatherResponse {
        // go to api and get the weather
        return WeatherAPI.api.getWeather(cityName)
    }

    suspend fun getWeatherFromAPIByLocation(lat : Double, log : Double ) {
        // go to api and get the weather
        // return WeatherResponse("Toronto")
    }

}