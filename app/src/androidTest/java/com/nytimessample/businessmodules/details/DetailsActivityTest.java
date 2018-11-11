package com.nytimessample.businessmodules.details;

import android.support.test.rule.ActivityTestRule;
import android.webkit.WebView;

import com.nytimessample.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Developer on 11-11-2018.
 */
public class DetailsActivityTest {

    @Rule
    ActivityTestRule<DetailsActivity> detailsActivityActivityTestRule = new ActivityTestRule<DetailsActivity>(DetailsActivity.class);
    DetailsActivity detailsActivity=null;
    DetailsPresenterImpl detailsPresenter;
    WebView webView;
    @Before
    public void setUp() throws Exception {
        detailsActivity = detailsActivityActivityTestRule.getActivity();
        detailsPresenter = new DetailsPresenterImpl();

    }

    @Test
    public void loadWebview(){
        webView = detailsActivity.findViewById(R.id.webview);
        String url = detailsActivity.getIntent().getExtras().getString("Item url");
        detailsPresenter.loadWebView(url,webView);
    }
    @After
    public void tearDown() throws Exception {
        detailsActivity = null;
    }

}