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

class EmployeeDashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmployeeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EmployeeScreen(modifier: Modifier = Modifier) {
    var desc by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var passengers by remember { mutableStateOf("") }
    var distance by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(20.dp)) {
        OutlinedTextField(value = desc, onValueChange = { desc = it }, label = { Text("Requirement Description") })
        OutlinedTextField(value = date, onValueChange = { date = it }, label = { Text("Date & Time") })
        OutlinedTextField(value = passengers, onValueChange = { passengers = it }, label = { Text("No. of Passengers") })
        OutlinedTextField(value = distance, onValueChange = { distance = it }, label = { Text("Approx Distance") })

        Button(onClick = { /* Save request to database later */ }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Submit Request")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeScreenPreview() {
    VehicleManagementAppTheme {
        EmployeeScreen()
    }
}
