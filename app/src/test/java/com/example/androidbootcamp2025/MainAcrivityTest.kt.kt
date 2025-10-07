package com.example.androidbootcamp2025

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.robolectric.RobolectricTestRunner
import org.junit.runner.RunWith
import androidx.activity.ComponentActivity
import org.robolectric.Robolectric

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .get()
    }

    @Test
    fun activity_isNotNull() {
        assertNotNull(activity)
    }

    @Test
    fun activity_isCreated() {
        assertTrue(activity is ComponentActivity)
    }
}
