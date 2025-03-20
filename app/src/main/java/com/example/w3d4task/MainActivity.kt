package com.example.w3d4task

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.w3d4task.ui.theme.W3D4TaskTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        executeCoroutines()
    }
}

private fun executeCoroutines() {
    val coroutineScope = CoroutineScope(Dispatchers.Main) //Use Dispatchers

    coroutineScope.launch {
        Log.d("Coroutine", "Starting Sequential Execution...")
        executeTasksSequentially()

        Log.d("Coroutine", "Starting Concurrent Execution...")
        executeTasksConcurrently()
    }
}

// Sequential Execution
private suspend fun executeTasksSequentially() {
    fetchUserData()
    processAnalyticsData()
    saveReportToDatabase()
}

// Concurrent Execution
private suspend fun executeTasksConcurrently() = coroutineScope {
    val job1 = launch { fetchUserData() }
    val job2 = launch { processAnalyticsData() }
    val job3 = launch { saveReportToDatabase() }

    job1.join()
    job2.join()
    job3.join()
}
