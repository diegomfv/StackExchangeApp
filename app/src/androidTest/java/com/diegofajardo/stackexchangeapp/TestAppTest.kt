package com.diegofajardo.stackexchangeapp

import androidx.test.espresso.intent.rule.IntentsTestRule
import com.diegofajardo.stackexchangeapp.app.TestApp
import com.diegofajardo.stackexchangeapp.ui.main.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class TestAppTest {

    @get:Rule
    val activityTestRule = IntentsTestRule(MainActivity::class.java, false, false)

    @Test
    fun test_app_is_running() {
        activityTestRule.launchActivity(null)
        val app = activityTestRule.activity.application
        assertEquals(app::class, TestApp::class)
    }

}