package com.example.weatherappsummer26.UILayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlin.collections.get
import kotlin.toString
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(weatherVM : WeatherViewModel = viewModel()){

    val data = weatherVM.weatherState.collectAsState()
    LaunchedEffect(key1 = "Toronto") {
        weatherVM.loadWeather("Toronto, ON, Canada")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        if (data.value == null){
            CircularProgressIndicator()
        }else {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(fontSize = 40.sp, text =  "Toronto" )
                Text(fontSize = 50.sp, text =   data.value!!.main.temp.toString()+"C")
                Text(fontSize = 35.sp, text = "Feels Like: " + data.value!!.main.feels_like.toString())
                Text(fontSize = 40.sp, text = data.value!!.weather[0].description)
            }
        }
    }




}