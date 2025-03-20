package com.example.w3d4task

import android.util.Log
import kotlinx.coroutines.*

suspend fun processAnalyticsData() = withContext(Dispatchers.Default) {
    try {
        Log.d("Coroutine", "Processing analytics data... Running on ${Thread.currentThread().name}")
        delay(1500) // Simulating data processing
        Log.d("Coroutine", "Analytics data processed successfully!")
    } catch (e: Exception) {//Error handling
        Log.e("Coroutine", "Error processing analytics data: ${e.message}")
    }
}
