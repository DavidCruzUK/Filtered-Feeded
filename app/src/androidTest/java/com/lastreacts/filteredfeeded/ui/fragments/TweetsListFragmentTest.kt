package com.lastreacts.filteredfeeded.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class TweetsListFragmentTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testTweetsAreDisplaying() {
        val textToType = "Android"
        val timeOnHold: Long = 3000 // 3S

        // Write some text to search
        Espresso.onView(ViewMatchers.withId(R.id.wordsToSearchEditText))
            .perform(ViewActions.typeText(textToType), ViewActions.closeSoftKeyboard())

        // Click is performed on the button
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
            .perform(ViewActions.click())

        // Check if RecyclerView in TweetsList Fragment is displayed
        Espresso.onView(ViewMatchers.withId(R.id.tweetsListRecyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Check shows Progressbar on loading.
        Espresso.onView(ViewMatchers.withId(R.id.progressBar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // progress dialog is now shown (on a good internet connection)
        Thread.sleep(timeOnHold)

        // Verify stream of tweets are been received and include in to the RecyclerView
        assert(recyclerViewItemCount() > 0)

    }

    @Test
    fun testShow420Error() {
        val textToType = "Android"
        val timeOnHold: Long = 3000 // 3S

        // Write some text to search
        Espresso.onView(ViewMatchers.withId(R.id.wordsToSearchEditText))
            .perform(ViewActions.typeText(textToType), ViewActions.closeSoftKeyboard())

        // Click is performed on the button
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
            .perform(ViewActions.click())

        Thread.sleep(timeOnHold)

        Espresso.pressBack()

        // Click is performed on the button
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
            .perform(ViewActions.click())

        Thread.sleep(timeOnHold)

        // Verify stream of tweets are been received and include in to the RecyclerView after 420 error
        assert(recyclerViewItemCount() > 0)

    }

    private fun recyclerViewItemCount(): Int {
        val recyclerView =
            activityRule.activity.findViewById(R.id.tweetsListRecyclerView) as RecyclerView
        return recyclerView.adapter!!.itemCount
    }
}