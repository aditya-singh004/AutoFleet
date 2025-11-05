package com.example.vehiclemanagementapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehiclemanagementapp.ui.theme.VehicleManagementAppTheme

class HODDashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HODScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HODScreen(modifier: Modifier = Modifier) {
    val requests = listOf("Trip to Client Meeting", "Airport Drop", "Official Conference")

    Column(modifier = modifier.padding(20.dp)) {
        Text("Pending Requests", style = MaterialTheme.typography.titleMedium)
        requests.forEach { req ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { /* Approve request */ }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = req)
                    Row {
                        Button(onClick = { /* Approve logic */ }, modifier = Modifier.padding(end = 8.dp)) {
                            Text("Approve")
                        }
                        Button(onClick = { /* Reject logic */ }) {
                            Text("Reject")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HODScreenPreview() {
    VehicleManagementAppTheme {
        HODScreen()
    }
}
