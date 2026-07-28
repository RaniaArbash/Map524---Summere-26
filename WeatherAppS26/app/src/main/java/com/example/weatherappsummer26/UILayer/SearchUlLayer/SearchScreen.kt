package com.example.weatherappsummer26.UILayer.SearchUlLayer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SearchScreen(navController: NavController,
                 vm: SearchViewModel = viewModel()) {

// I will add a search bar and a table
    var showAlert = remember { mutableStateOf(false) }
    var selectedCity: String = remember { mutableStateOf("").toString() }

    val cities by vm.cities.collectAsState();

    //val cities by vm.cities.collectAsState();
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                if (query.length > 3)
                    vm.onSearch(it)
                else
                    vm.noSearch()
            },
            label = { Text("Search city") },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn {
            items(
                cities
            ) { city ->
                Text(
                    text = city.addresstype+ ":" + city.displayName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp).clickable {
                            showAlert.value = true
                            selectedCity = city.name
                            navController.navigate("weather/${city.name}")
                             vm.noSearch()
                        }
                )

            }
        }

    }
}
