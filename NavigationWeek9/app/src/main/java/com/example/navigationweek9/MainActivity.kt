package com.example.navigationweek9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.navigationweek9.Scaffold.MyButtonBar
import com.example.navigationweek9.Scaffold.MyFAB
import com.example.navigationweek9.Scaffold.MyTopBar
import com.example.navigationweek9.navigation.MyNavHost
import com.example.navigationweek9.screens.CalculatorScreen
import com.example.navigationweek9.screens.LogInComposable
import com.example.navigationweek9.screens.StudentsListScreen
import com.example.navigationweek9.ui.theme.NavigationWeek9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var navController = rememberNavController()
            NavigationWeek9Theme {
             Scaffold(
                 topBar = {MyTopBar()},
                 bottomBar = {
                     MyButtonBar({path ->
                         navController.navigate(path)
                     })
                 },
                 floatingActionButton = {MyFAB()})
             {
                 MyNavHost(navController)

             }
            }
        }
    }
}

