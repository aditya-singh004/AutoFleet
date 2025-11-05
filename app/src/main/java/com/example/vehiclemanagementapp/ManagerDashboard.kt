package com.example.vehiclemanagementapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehiclemanagementapp.ui.theme.VehicleManagementAppTheme

class ManagerDashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ManagerScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ManagerScreen(modifier: Modifier = Modifier) {
    var vehicle by remember { mutableStateOf("") }
    var driver by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(20.dp)) {
        OutlinedTextField(value = vehicle, onValueChange = { vehicle = it }, label = { Text("Vehicle No.") })
        OutlinedTextField(value = driver, onValueChange = { driver = it }, label = { Text("Driver Name") })
        OutlinedTextField(value = contact, onValueChange = { contact = it }, label = { Text("Driver Contact") })

        Button(onClick = { /* Assign vehicle logic */ }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Assign Vehicle")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManagerScreenPreview() {
    VehicleManagementAppTheme {
        ManagerScreen()
    }
}
