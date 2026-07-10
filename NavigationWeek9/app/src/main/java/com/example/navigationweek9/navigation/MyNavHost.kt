package com.example.navigationweek9.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationweek9.screens.CalculatorScreen
import com.example.navigationweek9.screens.LogInComposable
import com.example.navigationweek9.screens.StudentsListScreen
import com.example.navigationweek9.screens.WelcomeScreen


@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItems.LogIn.path
    ) {
        composable(route = NavItems.LogIn.path) {
            LogInComposable(navController)
        }
        composable(
            route = "${NavItems.Welcome.path}/{name}"
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            WelcomeScreen(name)
        }
        composable(route = NavItems.Calculator.path) {
            CalculatorScreen()
        }
        composable(route = NavItems.StudentList.path) {
            StudentsListScreen()
        }
    }
}
