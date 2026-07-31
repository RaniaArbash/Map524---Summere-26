package com.example.weatherappsummer26.DataLayer.LocationDataLayer

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationService (context: Context){
    private val locationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)


    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getCurrentLocation(): Location? {
        return suspendCoroutine { cont->
            val token = CancellationTokenSource().token
            locationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                token
            ).addOnSuccessListener { location ->
                cont.resume(location)
            }
                .addOnFailureListener {
                    cont.resume(null)
                }
        }

    }

}