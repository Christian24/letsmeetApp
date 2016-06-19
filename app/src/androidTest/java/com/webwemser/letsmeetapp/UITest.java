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
 * 
 * @author Sergei Fladung
 */
@RunWith(AndroidJUnit4.class)
public class UITest {
	
	private String name = "Günther Gans";
	
	 @Rule
	 public ActivityTestRule<MainActivity> testingActivity = new ActivityTestRule<>(MainActivity.class);
	 
	 @Test
	 public void testSomething() {
		 
	 }
	
}