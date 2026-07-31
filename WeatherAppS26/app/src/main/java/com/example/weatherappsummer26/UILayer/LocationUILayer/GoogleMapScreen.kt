package com.example.weatherappsummer26.UILayer.LocationUILayer

import android.Manifest
import android.location.Location
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlin.collections.get
import kotlin.toString

@Composable
fun GoogleMapScreen(lvm: LocationViewModel = viewModel()) {

    val currentLocation = lvm.currentLocation.collectAsState()
    var markerPosition by remember { mutableStateOf<LatLng?>(null) }
    val weatherData = lvm.weatherState.collectAsState()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = @androidx.annotation.RequiresPermission(allOf = [android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION]) { granted ->
            if (granted) {
                lvm.fetchCurrentLocation()
            } else {
                Log.d("Error", "No permission")
            }
        })

    LaunchedEffect(key1 = Unit) {
        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)

    }
    if (currentLocation.value != null) {
        val cameraPostionState = rememberCameraPositionState {
            if (currentLocation.value != null){
                position = CameraPosition(LatLng(currentLocation.value!!.latitude, currentLocation.value!!.longitude), 10f, 1f, 1f)
            }
        }
        GoogleMap(
            Modifier.fillMaxSize(),
            cameraPostionState,
            onMapLongClick = { latlon ->
                markerPosition = latlon
                lvm.loadWeather(latlon.longitude, latlon.latitude)
            }
        ) {
            markerPosition.let {
                it?.let { position ->
                    Marker(
                        state = MarkerState(position),
                        title = "Selected Location"
                    )
                }
            }
        }
    }else {
        CircularProgressIndicator()
    }
    if (weatherData.value != null){
        weatherData?.let { weather ->
            Card (){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(fontSize = 20.sp, text =  "Lat: ${markerPosition?.latitude} Lon: ${markerPosition?.longitude}" )
                    Text(fontSize = 30.sp, text =   weather.value!!.main.temp.toString()+"C")
                    Text(fontSize = 15.sp, text = "Feels Like: " + weather.value!!.main.feels_like.toString())
                    Text(fontSize = 20.sp, text = weather.value!!.weather[0].description)
                }
            }

        }}

}