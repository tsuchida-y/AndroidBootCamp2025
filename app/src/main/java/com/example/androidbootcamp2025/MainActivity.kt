package com.example.androidbootcamp2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbootcamp2025.ui.theme.AndroidBootCamp2025Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBootCamp2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Youtube(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Youtube(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {AppBar()},
        bottomBar = { BottomNavigation() }
    ){padding ->  //パディングを自動で計算してくれる
        Column (
            modifier = Modifier.padding(padding)  //ボトムバー、トップバーの分だけ内側にずらす
        ){
            RegistrationImage()

            LazyColumn(modifier = modifier) {
                items(10) {item ->
                    ThumbnailItem()
                }
            }
        }
    }
}

val imageList = listOf(
    R.drawable.sample_image1,
    R.drawable.sample_image2,
    R.drawable.sample_image3,
    R.drawable.sample_image4,
    R.drawable.sample_image5,
    R.drawable.sample_image6,
    R.drawable.sample_image7,
    R.drawable.sample_image8
)


@Composable
fun RegistrationImage(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {items(imageList) { imageResource ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, //水平方向に中央寄せ
            modifier = modifier
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(65.dp)
                    .border(//枠線
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = CircleShape
                    )
                    .background(//背景色
                        color = Color.White,
                        shape = CircleShape
                    )
            )
            Text(
                text = stringResource(R.string.RegistrationName),
                fontSize = 11.sp
            )
        }
    } }
}

@Composable
fun ThumbnailItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 18.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // 高さを固定
        ) {
            Image(
                painter = painterResource(id = R.drawable.youtube_thumbnail3),
                contentDescription = "動画サムネ",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // 右下に動画時間を表示
            Text(
                text = "10:25",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Boxの右下に配置
                    .padding(8.dp)//外側の余白
                    .background(
                        Color.Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 4.dp, vertical = 2.dp)//内側の余白
            )
        }


        Row(
            modifier = Modifier.padding(top = 12.dp, start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.Top
        ) {
            // チャンネルアイコン
            Image(
                painter = painterResource(id = R.drawable.sample_image1), // ダミーのチャンネルアイコン
                contentDescription = "チャンネルアイコン",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .border(//枠線
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = CircleShape
                    )
                    .background(//背景色
                        color = Color.White,
                        shape = CircleShape
                    )
            )

            // タイトルと情報
            Column(
                modifier = Modifier.padding(start = 8.dp) ,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "【Kotlin】Youtubeクローンの作り方の解説",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 2
                )
                Text(
                    text = "チャンネル名・再生数 100万回・1日前",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "Premium",
                color = Color.Black,
                fontWeight = FontWeight.W700
            )
        },
        navigationIcon = {
            // 2. Imageコンポーザブルを配置
            Image(
                painter = painterResource(id = R.drawable.youtube_icon), // 表示したい画像リソースを指定
                contentDescription = "アプリのロゴ",
                modifier = Modifier
                    .padding(start = 16.dp) // 左側に余白を追加して見た目を調整
                    .size(45.dp)         // アイコンのサイズを指定
            )
        },
        actions = {
            IconButton(onClick = { /* その他メニュー処理 */ }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "通知"
                )
            }
            IconButton(onClick = { /* 検索処理 */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "検索"
                )
            }

        },
        // アプリバーの背景色などをテーマに合わせる
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
    )
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = ("ホーム")
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = ("ショート")
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = ("登録チャンネル"),
                    fontSize = 9.sp
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = ("マイページ")
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBootCamp2025Theme {
        Youtube()
    }
}