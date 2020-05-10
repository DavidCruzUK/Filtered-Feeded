package com.lastreacts.filteredfeeded.ui.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.activities.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainFragmentTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testMainFragmentLayout() {
        // Title Contain the correct test
        onView(withId(R.id.descriptionTextView))
            .check(matches(withText(R.string.description_title_text)))

        // EditText contain correct Hint
        onView(withId(R.id.wordsToSearchEditText))
            .check(matches(withHint(R.string.hint_word_search_edit_text)))

        // Button contain correct text
        onView(withId(R.id.searchButton))
            .check(matches(withText(R.string.search_text_button)))
    }

    @Test
    fun testToastIsDisplayedonEmptyEditText() {

        // Click is performed on the button
        onView(withId(R.id.searchButton))
            .perform(click())

        // Test if toast with warning text is displayed
        onView(withText(R.string.empty_search_toast_text))
            .inRoot(withDecorView(not(activityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun goToTweetsListFragment() {
        val textToType = "Android"

        // Write some text to search
        onView(withId(R.id.wordsToSearchEditText))
            .perform(typeText(textToType), closeSoftKeyboard())

        // Click is performed on the button
        onView(withId(R.id.searchButton))
            .perform(click())

        // Check if RecyclerView in TweetsList Fragment is displayed
        onView(withId(R.id.tweetsListRecyclerView))
            .check(matches(isDisplayed()))

    }
}
