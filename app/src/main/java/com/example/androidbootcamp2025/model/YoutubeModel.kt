package com.example.androidbootcamp2025.model

import androidx.annotation.DrawableRes

// 登録チャンネルのデータ構造
data class Channel(
    val name: String,
    @DrawableRes val iconRes: Int
)

// 動画のデータ構造
data class Video(
    val title: String,
    val channelName: String,
    @DrawableRes val thumbnailRes: Int,
    @DrawableRes val channelIconRes: Int,
    val viewCount: String,
    val uploadedAt: String,
    val likeCount: Int
)
