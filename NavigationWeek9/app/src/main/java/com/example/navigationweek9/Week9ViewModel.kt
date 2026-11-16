package com.example.navigationweek9

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.navigationweek9.screens.Student


class Week9ViewModel : ViewModel() {
    var name by mutableStateOf("")
        private set
    var students by mutableStateOf(listOf(
        Student("John Smith", "George Brown College"),
        Student("Emily Johnson", "Seneca Polytechnic"),
        Student("Michael Brown", "Humber Polytechnic"),
        Student("Sarah Wilson", "Centennial College"),
        Student("David Lee", "Sheridan College"),
        Student("Olivia Martin", "Algonquin College"),
        Student("James Taylor", "Fanshawe College"),
        Student("Sophia White", "Mohawk College"),
        Student("Daniel Garcia", "Conestoga College"),
        Student("Emma Anderson", "Durham College")
    ))
        private set


     fun updateName(n:String){
        name = n
    }
}