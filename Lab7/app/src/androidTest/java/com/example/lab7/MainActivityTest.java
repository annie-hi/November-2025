package com.example.lab7;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import androidx.annotation.UiThread;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    private TextView text;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity(); // getScenario()
    }

    @Test
    @UiThreadTest
    public void checkFirstName() throws Exception{
        assertNotNull(mActivity.findViewById(R.id.firstName));
        text.setText("user1");
        String name = text.getText().toString();
        assertNotEquals("user", name);
    }

}
