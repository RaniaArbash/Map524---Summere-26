package com.example.navigationweek9.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var count by mutableStateOf(0)
        private set

    fun increas(){
        count++
    }
    fun decreas(){
        count--
    }

    fun reset(){
        count = 0
    }





}