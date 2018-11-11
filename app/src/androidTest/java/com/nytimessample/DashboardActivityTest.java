package com.nytimessample;

import android.support.test.rule.ActivityTestRule;
import android.test.ActivityUnitTestCase;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Developer on 11-11-2018.
 */
public class DashboardActivityTest {

    @Rule
    public ActivityTestRule<DashboardActivity> dashboardActivityActivityTestRule = new ActivityTestRule<>(DashboardActivity.class);
    DashboardActivity dashboardActivity = null;
    @Before
    public void setUp() throws Exception {
        dashboardActivity = dashboardActivityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        dashboardActivity = null;
    }

    @Test
    public void testLaunch(){
        View drawer_layout = dashboardActivity.findViewById(R.id.drawer_layout);
        View listview = dashboardActivity.findViewById(R.id.mainlist);
        View framework = dashboardActivity.findViewById(R.id.framework);
        assertNotNull(drawer_layout);
        assertNotNull(listview);
        assertNotNull(framework);
    }

    @Test
    public void testNavigation(){
        View drawer_layout = dashboardActivity.findViewById(R.id.drawer_layout);
        drawer_layout.performClick();
    }

    @Test
    public void getLayout() throws Exception {

    }

    @Test
    public void setupActivityComponent() throws Exception {
    }

    @Test
    public void onBackPressed() throws Exception {

    }

}