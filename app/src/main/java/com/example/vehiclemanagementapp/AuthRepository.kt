package com.example.vehiclemanagementapp.data

import kotlinx.coroutines.delay

data class User(
    val email: String,
    val role: String,
    val department: String = "CSE",
    val employeeId: String = "EMP001"
)

object AuthRepository {
    // Dummy in-memory users for now (simulate DB)
    private val users = mutableListOf(
        User("employee@example.com", "employee", "CSE", "E101"),
        User("hod@example.com", "hod", "CSE", "H201"),
        User("manager@example.com", "manager", "Admin", "M301")
    )

    suspend fun login(email: String, password: String): User? {
        // Simulate network delay
        delay(1000)
        return users.find { it.email == email }
    }

    suspend fun signup(email: String, password: String, role: String): Boolean {
        delay(500)
        if (users.any { it.email == email }) return false
        users.add(User(email, role))
        return true
    }
}
