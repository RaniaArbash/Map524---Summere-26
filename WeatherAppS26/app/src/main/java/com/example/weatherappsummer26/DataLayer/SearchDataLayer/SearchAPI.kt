package com.example.weatherappsummer26.DataLayer.SearchDataLayer


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.Format

interface GeoBytesAPI {
    @GET("/search")
   suspend fun autoCompleteCity(
        @Query(value = "q") cityName: String,
        @Query(value = "format") format: String = "jsonv2",
        @Query(value = "limit") limit : Int = 20
    ): List<CityClass>
}

object CitiesAPIService {
    private val BASE_URL = "https://nominatim.openstreetmap.org"
    val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header(
                    "User-Agent",
                    "WeatherApp/1.0 (raniaarbash@hotmail.com)"
                )
                .build()
            chain.proceed(request)
        }
        .build()

    val api by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GeoBytesAPI::class.java)
    }

}