package com.example.viewmodeldemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigationweek9.viewmodels.CounterViewModel

@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel()) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Counter App",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = counterViewModel.count.toString(),
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    counterViewModel.increas()
                }
            ) {
                Text("Increase")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    counterViewModel.decreas()
                }
            ) {
                Text("Decrease")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                   counterViewModel.reset()
                }
            ) {
                Text("Reset")
            }
        }
    }
}