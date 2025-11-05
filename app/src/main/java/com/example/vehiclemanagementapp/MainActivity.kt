package com.example.vehiclemanagementapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehiclemanagementapp.ui.theme.VehicleManagementAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainDashboard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainDashboard(modifier: Modifier = Modifier) {
    val context = LocalContext.current   // ✅ use LocalContext for navigation

    Column(modifier = modifier.padding(20.dp)) {
        Button(
            onClick = { context.startActivity(Intent(context, EmployeeDashboard::class.java)) },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Employee Dashboard")
        }

        Button(
            onClick = { context.startActivity(Intent(context, HODDashboard::class.java)) },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("HOD Dashboard")
        }

        Button(
            onClick = { context.startActivity(Intent(context, ManagerDashboard::class.java)) },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Transport Manager Dashboard")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainDashboardPreview() {
    VehicleManagementAppTheme {
        MainDashboard()
    }
}
