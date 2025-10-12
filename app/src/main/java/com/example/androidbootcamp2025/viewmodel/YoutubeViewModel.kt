package com.example.androidbootcamp2025.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbootcamp2025.model.YoutubeRepository
import com.example.androidbootcamp2025.model.Channel
import com.example.androidbootcamp2025.model.Video
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// UIの状態を表すデータクラス
data class YoutubeUiState(
    val channels: List<Channel> = emptyList(),
    val videos: List<Video> = emptyList()
)

class YoutubeViewModel(
    private val repository: YoutubeRepository = YoutubeRepository()
) : ViewModel() {

    // UIに公開する状態
    private val _uiState = MutableStateFlow(YoutubeUiState())
    val uiState: StateFlow<YoutubeUiState> = _uiState.asStateFlow()

    init {
        // ViewModelが作成されたときにデータを取得する
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val channels = repository.getChannels()
            val videos = repository.getVideos()
            _uiState.update { currentState ->
                currentState.copy(
                    channels = channels,
                    videos = videos
                )
            }
        }
    }
}
