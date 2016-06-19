package com.webwemser.letsmeetapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Testclass in order to test Userinteractions with application
 * @author Sergei Fladung
 */
@RunWith(AndroidJUnit4.class)
public class UITest {

    @Rule
    public ActivityTestRule<MainActivity> testingActivity = new ActivityTestRule<>(MainActivity.class);

    /**
     * Testuses should be successfull logged in.
     */
    @Test
    public void loginTest() {
        String username = "Charlotte";
        String password = "Webwemser";

        onView(withId(R.id.username_text)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.password_text)).perform(typeText(password), closeSoftKeyboard());

        onView(withId(R.id.login_button)).perform(click());
    }

}