package com.example.w3d4task

import android.util.Log
import kotlinx.coroutines.*

suspend fun fetchUserData() = withContext(Dispatchers.IO) {
    try {
        Log.d("Coroutine", "Fetching user data... Running on ${Thread.currentThread().name}")
        delay(1000) // Simulating network request
        Log.d("Coroutine", "User data fetched successfully!")
    } catch (e: Exception) {//Error handling
        Log.e("Coroutine", "Error fetching user data: ${e.message}")
    }
}
