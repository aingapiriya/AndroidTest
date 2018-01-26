package com.codemobiles.cmmvptest.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.codemobiles.cmmvptest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCheckUserNameEditTextIsDisplayed() {
        onView(withId(R.id.username_editText)).check(matches(isDisplayed()));
    }

    @Test
    public void testCheckPasswordEditTextIsDisplayed() {
        onView(withId(R.id.password_editText)).check(matches(isDisplayed()));
    }

    @Test
    public void testCheckErrorMessageIsDisplayedForEmptyData() {
        onView(withId(R.id.login_button)).check(matches(isDisplayed())).perform(click());
        onView(withText("Username or Password Incorrect")).check(matches(isDisplayed()));
    }

    @Test
    public void testCheckLoginSuccess() {
        onView(withId(R.id.username_editText)).perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.password_editText)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.login_button)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login Success")).check(matches(isDisplayed()));
    }
}