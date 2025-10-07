package com.example.androidbootcamp2025

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.androidbootcamp2025.ui.theme.AndroidBootCamp2025Theme

@RunWith(AndroidJUnit4::class)
class MainActivityComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun youtube_displaysAppBar() {
        composeTestRule.setContent {
            AndroidBootCamp2025Theme {
                Youtube()
            }
        }

        composeTestRule
            .onNodeWithText("アプリバー!")
            .assertIsDisplayed()
    }

    @Test
    fun youtube_displaysSubscriberText() {
        composeTestRule.setContent {
            AndroidBootCamp2025Theme {
                Youtube()
            }
        }

        composeTestRule
            .onNodeWithText("登録者")
            .assertIsDisplayed()
    }

    @Test
    fun youtube_displaysVideoText() {
        composeTestRule.setContent {
            AndroidBootCamp2025Theme {
                Youtube()
            }
        }

        composeTestRule
            .onNodeWithText("動画")
            .assertIsDisplayed()
    }

    @Test
    fun youtube_displaysBottomBar() {
        composeTestRule.setContent {
            AndroidBootCamp2025Theme {
                Youtube()
            }
        }

        composeTestRule
            .onNodeWithText("ボトムバー")
            .assertIsDisplayed()
    }
}
