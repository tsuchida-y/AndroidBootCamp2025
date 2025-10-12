package com.example.androidbootcamp2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.androidbootcamp2025.ui.theme.AndroidBootCamp2025Theme
import com.example.androidbootcamp2025.ui.YoutubeScreen
import kotlin.getValue
import com.example.androidbootcamp2025.viewmodel.YoutubeViewModel

class MainActivity : ComponentActivity() {
    // ViewModelのインスタンスをActivityに紐づけて作成
    private val viewModel: YoutubeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBootCamp2025Theme {
                YoutubeScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}