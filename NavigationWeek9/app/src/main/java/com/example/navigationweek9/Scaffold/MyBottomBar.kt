package com.example.navigationweek9.Scaffold

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.navigationweek9.navigation.NavItems

@Composable
fun MyButtonBar(onNavigate : (String)-> Unit) {
    var list = listOf(NavItems.LogIn , NavItems.StudentList, NavItems.Calculator, NavItems.CounterScreen)

    var selectedIndex = remember { mutableStateOf(0) };// remember the selected screen

    NavigationBar{
        list.forEachIndexed { index, item ->
            NavigationBarItem(onClick = {
                selectedIndex.value = index
                onNavigate(item.path)
            },
                selected = selectedIndex.value == index ,
                label = { Text(item.path) },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "menu item")
                }
            )
        }
    }
}
