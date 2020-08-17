package com.diegofajardo.stackexchangeapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivity
import com.diegofajardo.stackexchangeapp.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityUiTest {

    @get:Rule
    val activityTestRule = IntentsTestRule(MainActivity::class.java, false, false)

    @Test
    fun submit_button_is_displayed() {
        activityTestRule.launchActivity(null)
        onView(withId(R.id.submit_query_button)).check(matches(isDisplayed()))
    }

    @Test
    fun search_edit_text_is_displayed() {
        activityTestRule.launchActivity(null)
        onView(withId(R.id.search_input)).check(matches(isDisplayed()))
    }

    @Test
    fun click_item_in_recycler_view_launches_DetailActivity() {
        activityTestRule.launchActivity(null)
        onView(withId(R.id.search_input)).perform(typeText("alpha"))
        onView(withId(R.id.submit_query_button)).perform(click())
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        intended(hasComponent(DetailActivity::class.java.name))
    }
}