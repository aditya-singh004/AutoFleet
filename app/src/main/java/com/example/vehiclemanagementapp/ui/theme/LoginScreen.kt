package com.example.vehiclemanagementapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.vehiclemanagementapp.data.AuthRepository

@Composable
fun LoginScreen(onLoginSuccess: (String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Vehicle Management Login", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                scope.launch {
                    loading = true
                    val user = AuthRepository.login(email, password)
                    loading = false
                    if (user != null) {
                        message = "Welcome, ${user.role.uppercase()}"
                        onLoginSuccess(user.role)
                    } else {
                        message = "Invalid credentials!"
                    }
                }
            },
            enabled = !loading
        ) {
            Text(if (loading) "Logging in..." else "Login")
        }

        Spacer(Modifier.height(12.dp))
        Text(text = message, color = MaterialTheme.colorScheme.error)
    }
}
