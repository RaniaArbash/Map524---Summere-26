package com.example.navigationweek9.screens


import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigationweek9.Week9ViewModel
import com.example.navigationweek9.navigation.NavItems

@Composable
fun LogInComposable(navController: NavHostController,
                    viewModel: Week9ViewModel = viewModel()) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = viewModel.name,
            onValueChange = { viewModel.updateName(it)  },
            label = { Text("Enter your name") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("${NavItems.Welcome.path}/${viewModel.name}")
            }
        ) {
            Text("Go to Counter")
        }

    }
}