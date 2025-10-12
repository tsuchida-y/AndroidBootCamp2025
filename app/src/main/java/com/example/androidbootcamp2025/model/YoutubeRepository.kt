package com.example.androidbootcamp2025.model

import com.example.androidbootcamp2025.R

// データの取得元を抽象化するクラス
class YoutubeRepository {

    fun getChannels(): List<Channel> {
        return listOf(
            Channel("チャンネル1", R.drawable.sample_image1),
            Channel("チャンネル2", R.drawable.sample_image2),
            Channel("チャンネル3", R.drawable.sample_image3),
            Channel("チャンネル4", R.drawable.sample_image4),
            Channel("チャンネル5", R.drawable.sample_image5),
            Channel("チャンネル6", R.drawable.sample_image6),
            Channel("チャンネル7", R.drawable.sample_image7),
            Channel("チャンネル8", R.drawable.sample_image8),
        )
    }

    fun getVideos(): List<Video> {
        return List(10) {
            Video(
                title = "【Kotlin】Youtubeクローンの作り方の解説",
                channelName = "チャンネル名",
                thumbnailRes = R.drawable.youtube_thumbnail2,
                channelIconRes = R.drawable.sample_image1,
                viewCount = "100万回",
                uploadedAt = "1日前"
            );
            Video(
                title = "【料理】自家製パンの作り方",
                channelName = "チャンネル名",
                thumbnailRes = R.drawable.youtube_thumbnail3,
                channelIconRes = R.drawable.sample_image2,
                viewCount = "100万回",
                uploadedAt = "1日前"
            )
        }
    }
}
