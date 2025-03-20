package com.example.w3d4task

import android.util.Log
import kotlinx.coroutines.*

suspend fun saveReportToDatabase() = withContext(Dispatchers.IO) {
    try {
        Log.d("Coroutine", "Saving report to database... Running on ${Thread.currentThread().name}")
        delay(1200) // Simulating database operation
        Log.d("Coroutine", "Report saved successfully!")
    } catch (e: Exception) {//Error handling
        Log.e("Coroutine", "Error saving report: ${e.message}")
    }
}
