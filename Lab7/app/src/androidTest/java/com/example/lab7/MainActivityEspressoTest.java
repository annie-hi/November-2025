package com.example.lab7;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private MainActivity main;

    @Before
    public void setUp() throws Exception{
        mActivityTestRule.getScenario().onActivity(activity -> main = activity);
    }

    @Test
    public void firstNameIsValid(){
        onView(withId(R.id.firstName)).perform(typeText("1230"), closeSoftKeyboard());
        onView(withId(R.id.lastName)).perform(typeText("1230"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("email@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.lab7_btn)).perform(click());
        onView(withText("Invalid firstname")).check(matches(isDisplayed()));
    }

    @Test
    public void lastNameIsValid(){
        onView(withId(R.id.firstName)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.lastName)).perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("email@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.lab7_btn)).perform(click());
        onView(withText("Invalid lastname")).check(matches(isDisplayed()));
    }




}
