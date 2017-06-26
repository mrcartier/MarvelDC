package com.example.cartier.marveldc;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Cartier on 2/8/2017.
 */

public class RecyclerViewTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public RecyclerViewTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void testClickAtPosition() {
        //perform click in first RecyclerView element of Marvel Fragment
        onView(withId(R.id.marvel_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}

