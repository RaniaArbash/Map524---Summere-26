package com.example.weatherappsummer26.DataLayer

class WeatherRepo {

    suspend fun getWeatherFromAPIByCityName(cityName : String ): WeatherResponse {
        // go to api and get the weather
        var weatherObj = WeatherObject("overcast clouds","04d")
        var weatherlist = mutableListOf<WeatherObject>()
        weatherlist.add(weatherObj)

        var mainobj = MainObject(25.06,24.82,46)
        var coordsObj = Coords(43.7001,-79.4163,)
        var static_weather_response = WeatherResponse("Toronto, ON, Canada",weatherlist,mainobj, coordsObj)


        return static_weather_response
    }

    suspend fun getWeatherFromAPIByLocation(lat : Double, log : Double ) {
        // go to api and get the weather
        // return WeatherResponse("Toronto")
    }

}