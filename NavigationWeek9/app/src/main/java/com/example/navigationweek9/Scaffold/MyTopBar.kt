package com.example.navigationweek9.Scaffold

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    val context = LocalContext.current;
    TopAppBar(
        title = { Text("Application") },
        navigationIcon = { // the icon to the left top corner
            IconButton(onClick = {
                Toast.makeText(context,"Menu Clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Menu, contentDescription = "Menue")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context,"Done Clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Done, contentDescription = "Done")
            }
            IconButton(onClick = {
                Toast.makeText(context,"Call Clicked", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Call, contentDescription = "Call")
            }
        }
    )

}