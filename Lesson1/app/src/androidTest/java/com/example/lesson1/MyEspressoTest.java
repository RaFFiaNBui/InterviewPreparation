package com.example.lesson1;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MyEspressoTest {

    private String value;

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        value = "35";
    }

    @Test
    public void onClick() {
        onView(withId(R.id.editText)).perform(typeText(value), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.editText)).check(matches(withText(value)));
        onView(withId(R.id.textView)).check(matches(withText("9.72")));

    }
}
