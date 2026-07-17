package com.example.navigationweek9.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face

sealed class NavItems {
    object LogIn : Item("logIn","Log In", Icons.Default.AccountCircle)
    object Welcome : Item("welcome","Welcome", Icons.Default.Face)
    object Calculator : Item("calculator","Calculator", Icons.Default.AddCircle)
    object StudentList: Item("List", "Students List",Icons.Default.DateRange)

    object CounterScreen: Item("Counter", "Counter",Icons.Default.DateRange)

}