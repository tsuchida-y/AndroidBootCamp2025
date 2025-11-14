package com.example.androidbootcamp2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.androidbootcamp2025.ui.YoutubeScreen
import com.example.androidbootcamp2025.ui.components.AppBar
import com.example.androidbootcamp2025.ui.components.BottomNavigation
import com.example.androidbootcamp2025.ui.navigation.AppNavHost
import com.example.androidbootcamp2025.ui.theme.AndroidBootCamp2025Theme
import com.example.androidbootcamp2025.viewmodel.YoutubeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBootCamp2025Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {

    //ナビゲーションコントローラーの作成
    val navController = rememberNavController()

    //各画面で共通している部分を構築
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AppBar() },
        bottomBar = {
            BottomNavigation(
                //クリックされたら画面のルート名を受け取る
                onNavigate = { route ->

                    //現在画面のルートを取得
                    val currentRoute = navController.currentBackStackEntry?.destination?.route

                    //同じ画面への遷移を防ぐ
                    if (currentRoute != route) {

                        //画面遷移実行
                        navController.navigate(route) {
                            //これがないと、画面遷移のたびに画面が積み重なってしまう
                            //startDestinationId：最初の画面のID
                            //スタックには常に[最初の画面, 現在の画面]だけが残る
                            popUpTo(navController.graph.startDestinationId) {

                                //遷移前の画面の状態を保存する
                                //(例: スクロール位置・入力フォーム内容・選択状態など)
                                saveState = true
                            }

                            //同じ画面を重複して開かない
                            //これがないと5回ホームボタンを押すと「ホーム」が5つ積まれる
                            launchSingleTop = true

                            //これがあることで、スクロール位置などを記憶し、画面遷移前の状態に戻せる
                            restoreState = true
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            startDestination = "subscriptions",
            modifier = Modifier.padding(paddingValues)
        )
    }
}