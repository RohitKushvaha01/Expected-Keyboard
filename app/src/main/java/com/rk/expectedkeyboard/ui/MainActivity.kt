package com.rk.expectedkeyboard

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rk.expectedkeyboard.ui.theme.ExpectedKeyboardTheme
import java.io.File
import java.util.concurrent.locks.ReentrantLock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpectedKeyboardTheme {
                var text by remember { mutableStateOf("") }
                val context = LocalContext.current // Get context for launching the intent

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp) // Spacing between items
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth(0.8f), // 80% of the screen width
                                onClick = {
                                    val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
                                    intent.flags += Intent.FLAG_ACTIVITY_NEW_TASK
                                    context.startActivity(intent) // Use context to start the activity
                                }
                            ) {
                                Text("System Keyboard Settings")
                            }

                            TextField(
                                value = text,
                                onValueChange = { newText -> text = newText },
                                placeholder = { Text("Type here") },
                                modifier = Modifier.fillMaxWidth(0.8f) // 80% width for better UI
                            )
                        }
                    }
                }
            }
        }
    }
}