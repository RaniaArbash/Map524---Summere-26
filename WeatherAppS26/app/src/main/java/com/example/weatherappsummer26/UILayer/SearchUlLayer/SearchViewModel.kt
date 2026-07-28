package com.example.weatherappsummer26.UILayer.SearchUlLayer

import androidx.lifecycle.ViewModel
import com.example.weatherappsummer26.DataLayer.SearchDataLayer.CityClass
import com.example.weatherappsummer26.DataLayer.SearchDataLayer.SearchRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay

class SearchViewModel : ViewModel() {

    // what should change and update the search result
    // list of cities should be the state variable

    private val repo = SearchRepo()
    var cityList = emptyList<CityClass>()
    private val _cities = MutableStateFlow<List<CityClass>>(cityList);
    var cities : MutableStateFlow<List<CityClass>> = _cities

    fun onSearch(query: String){
        viewModelScope.launch {
            _cities.value = repo.searchForCities(query)
            delay(300)
        }
    }

    fun noSearch(){
        cities.value = emptyList()
    }


}