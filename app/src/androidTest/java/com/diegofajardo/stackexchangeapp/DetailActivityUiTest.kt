package com.diegofajardo.stackexchangeapp

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivity
import com.diegofajardo.stackexchangeapp.utils.SimpleDateConverter
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DetailActivityUiTest {

    @get:Rule
    val activityTestRule = IntentsTestRule(DetailActivity::class.java, false, false)

    private val user = User(
        1,
        "username",
        "reputation",
        BadgeCounts(1, 2, 3),
        "location",
        "10",
        1304684964,
        "someUrl"
    )

    private val intent = Intent().apply { putExtra(DetailActivity.ARGUMENT_USER, user) }

    @Test
    fun avatar_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.avatar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun username_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.username)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.username)).check(ViewAssertions.matches(ViewMatchers.withSubstring("username")))
    }

    @Test
    fun reputation_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.reputation)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.reputation)).check(ViewAssertions.matches(ViewMatchers.withSubstring("reputation")))
    }

    @Test
    fun bronze_badges_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.badges_bronze)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.badges_bronze)).check(ViewAssertions.matches(ViewMatchers.withSubstring("1")))
    }

    @Test
    fun silver_badges_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.badges_silver)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.badges_silver)).check(ViewAssertions.matches(ViewMatchers.withSubstring("2")))
    }

    @Test
    fun gold_badges_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.badges_gold)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.badges_gold)).check(ViewAssertions.matches(ViewMatchers.withSubstring("3")))
    }

    @Test
    fun location_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.location)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.location)).check(ViewAssertions.matches(ViewMatchers.withSubstring("location")))
    }

    @Test
    fun age_is_displayed() {
        activityTestRule.launchActivity(intent)
        onView(ViewMatchers.withId(R.id.age)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.age)).check(ViewAssertions.matches(ViewMatchers.withSubstring("10")))
    }

    @Test
    fun creation_date_is_displayed() {
        activityTestRule.launchActivity(intent)
        val datePattern = "dd-mm-yyyy"
        val displayedDate = SimpleDateConverter(SimpleDateFormat(datePattern, Locale.getDefault())).getDateAsString(user.creationDate)
        onView(ViewMatchers.withId(R.id.creation_date)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.creation_date)).check(ViewAssertions.matches(ViewMatchers.withSubstring(displayedDate)))
    }

    @Test
    fun on_back_pressed_kills_activity () {
        activityTestRule.launchActivity(intent)
        Espresso.pressBackUnconditionally()
        assertTrue(activityTestRule.activity.isDestroyed)
    }
}