package com.example.androidbootcamp2025.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidbootcamp2025.ui.components.AppBar
import com.example.androidbootcamp2025.ui.components.BottomNavigation
import com.example.androidbootcamp2025.ui.components.ChannelItem
import com.example.androidbootcamp2025.ui.components.VideoItem
import com.example.androidbootcamp2025.viewmodel.YoutubeViewModel

@Composable
fun YoutubeScreen(
    modifier: Modifier = Modifier,
    viewModel: YoutubeViewModel,
    navController: androidx.navigation.NavHostController // NavControllerを引数で受け取る
) {
    // ViewModelのuiStateを監視し、変更があれば再Composeされる
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {AppBar()},
        bottomBar = { BottomNavigation(
            onNavigate = { route ->
                navController.navigate(route) {
                    // スタックに同じ画面が積み重ならないようにする設定
                    launchSingleTop = true
                }
            }
        ) }
    ){padding ->  //パディングを自動で計算してくれる
        Column (
            //ボトムバー、トップバーの分だけ内側にずらす
            modifier = Modifier.padding(padding)
        ){
            // チャンネルリスト
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(uiState.channels) { channel ->
                    ChannelItem(channel = channel)
                }
            }
            // 動画リスト
            LazyColumn(modifier = modifier) {
                items(uiState.videos) {video ->
                    VideoItem(video = video)
                }
            }
        }
    }
}