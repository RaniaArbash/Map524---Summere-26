package com.example.weatherappsummer26.UILayer.LocationUILayer

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WeatherInLocationScreen(lvm : LocationViewModel = viewModel()){

    // first I need the location of the device == lon and lat
    // then I need the weather in that location

    val currentLocation = lvm.currentLocation.collectAsState()
    val weatherInLocation = lvm.weatherState.collectAsState()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = @androidx.annotation.RequiresPermission(allOf = [android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION]) { granted ->
            if (granted) {
                lvm.fetchCurrentLocation()
            }else {
                Log.d("Error","No permission")
            }
        } )
    LaunchedEffect(key1 = Unit) {
        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (currentLocation.value == null ){
            CircularProgressIndicator()
        }else {
            lvm.loadWeather(currentLocation.value!!.longitude, currentLocation.value!!.latitude)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(fontSize = 40.sp, text = "Lat ${currentLocation.value!!.latitude}")
                Text(fontSize = 40.sp, text = "Lon ${currentLocation.value!!.longitude}")
                Spacer(modifier = Modifier.height(20.dp))
                if (weatherInLocation.value != null) {
                    Text(fontSize = 50.sp, text = weatherInLocation.value!!.main.temp.toString() + "C")
                    Text(
                        fontSize = 35.sp,
                        text = "Feels Like: " + weatherInLocation.value!!.main.feels_like.toString()
                    )
                    Text(fontSize = 40.sp, text = weatherInLocation.value!!.weather[0].description)
                    Text(fontSize = 40.sp, text = weatherInLocation.value!!.name)

                    Button(onClick = {
                        lvm.fetchCurrentLocation()
                    }) {
                        Text("Refresh Location")
                    }
                }else {
                    CircularProgressIndicator()
                }
            }


        }

    }



}