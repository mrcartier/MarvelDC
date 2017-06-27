package com.example.cartier.marveldc;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by cartier on 2/8/2017.
 */
@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest extends ActivityTestRule<MainActivity> {

    public RecyclerViewTest() {
        super(MainActivity.class);
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testClickAtPosition() {
        //perform click in first RecyclerView element of Marvel Fragment
        onView(withId(R.id.marvel_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}

