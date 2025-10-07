package com.example.androidbootcamp2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

    Scaffold(
        bottomBar = { BottomNavigation() }
    ){Padding ->  //パディングを自動で計算してくれる
        Column (
            modifier = Modifier.padding(Padding)  //ボトムバーの分だけ内側にずらす
        ){
            Text(
                text = "アプリバー!",
                modifier = modifier
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = modifier
            ) {
                items(imageList) { imageResource ->
                    RegistrationImage(imageResource = imageResource)
                }
            }

            LazyColumn(modifier = modifier) {
                items(10) {item ->
                    Text(
                        text = "動画",
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Composable
fun RegistrationImage(
    imageResource: Int,
    modifier: Modifier = Modifier
) {
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
                    width = 2.dp,
                    color = Color.DarkGray,
                    shape = CircleShape
                )
                .background(//背景色
                    color = Color.LightGray,
                    shape = CircleShape
                )
        )
        Text(
            text = stringResource(R.string.RegistrationName),
            fontSize = 12.sp
        )
    }
}


@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant, //背景色をアプリのテーマに合わせる
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