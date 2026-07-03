package com.example.week8_v2project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week8_v2project.ui.theme.Week8V2ProjectTheme

// John
// 25
// 6 + 1 = 7

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week8V2ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentProfile()
                }
            }
        }
    }
}

// M V VM
// Model = Services == Has no idea about UI
// View = Composalbe ===> has no idea about the logic (Model)
// ViewModel  ==  Main communication points ()

@Composable
fun StudentProfile(){

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var showProfile by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("Student Profile")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = name,
            onValueChange = {name = it },
            label = {Text("Enter Your Name")} )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = age,
            onValueChange = {age = it},
            label = {Text("Enter Your Age")})
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                showProfile = !showProfile
        }) {
            Text("Show Profile")
        }
        if (showProfile && !name.isEmpty() && !age.isEmpty()){
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column() {
                        Text("Studnet Info")
                        Text("Name: ${name}")
                        Text ("Age: ${age}")
                    }
                }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week8V2ProjectTheme {

        StudentProfile()

    }
}