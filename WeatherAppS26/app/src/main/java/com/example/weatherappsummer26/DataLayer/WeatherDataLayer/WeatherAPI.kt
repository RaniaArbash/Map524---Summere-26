package com.example.weatherappsummer26.DataLayer.WeatherDataLayer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapAPI {
    @GET("weather")
    suspend fun getWeather(
        @Query(value = "q") cityName: String,
        @Query(value = "appid") appid: String = "ecf5553cc5b15522aea8026824cb8085",
        @Query(value = "units") units : String = "metric"
    ): WeatherResponse

    @GET("weather")
    suspend fun getWeatherInLocation(
        @Query(value = "lat") lat: Double,
        @Query(value = "lon") lon: Double,
        @Query(value = "appid") appid: String = "ecf5553cc5b15522aea8026824cb8085",
        @Query(value = "units") units : String = "metric"
    ): WeatherResponse



}

object WeatherAPI{
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val api by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(OpenWeatherMapAPI::class.java)
    }

}