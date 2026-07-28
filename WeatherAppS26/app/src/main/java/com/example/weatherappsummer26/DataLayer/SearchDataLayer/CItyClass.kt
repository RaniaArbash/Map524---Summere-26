package com.example.weatherappsummer26.DataLayer.SearchDataLayer
import com.google.gson.annotations.SerializedName

data class CityClass (
    val name: String,
    val lat: String,
    val lon: String,
    @SerializedName("display_name")
    val displayName: String,
    val addresstype: String
)

