package com.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.activitylifecycle.ui.theme.ActivityLifecycleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "onCreate() called")
        setContent {
            ActivityLifecycleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LifecycleScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy() called")
    }
}

@Composable
fun LifecycleScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Activity Lifecycle", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Смотрите логи в Logcat с тегом 'Lifecycle'", style = MaterialTheme.typography.bodyMedium)
    }
}