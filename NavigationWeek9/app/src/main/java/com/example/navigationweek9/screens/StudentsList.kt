package com.example.navigationweek9.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Student(
    val name: String,
    val college: String
)

@Composable
fun StudentsListScreen() {

    val students = listOf(
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
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Student Directory",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(students) { student ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = student.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = student.college,
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }

            }

        }

    }

}