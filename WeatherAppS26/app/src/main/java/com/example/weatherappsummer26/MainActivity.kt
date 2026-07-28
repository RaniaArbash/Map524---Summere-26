package com.example.weatherappsummer26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weatherappsummer26.UILayer.Navigation.MainScaffold
import com.example.weatherappsummer26.UILayer.SearchUlLayer.SearchScreen
import com.example.weatherappsummer26.UILayer.WeatherUILayer.WeatherScreen
import com.example.weatherappsummer26.ui.theme.WeatherAppSummer26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppSummer26Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScaffold()
                }
            }
        }
    }
}
