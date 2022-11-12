package com.myapp.reecetest

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun recyclerViewTest() {
        val recyclerView: RecyclerView = activityRule.activity.findViewById(R.id.recyclerview)
        val itemCount = recyclerView.adapter?.itemCount
        if (itemCount != null) {
            Espresso.onView(withId(R.id.recyclerview))
                .perform(
                    RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        itemCount.minus(
                            1
                        )
                    )
                )
        }
    }
}

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


