package com.nytimessample.businessmodules.details;

import android.webkit.WebView;
import android.widget.ProgressBar;

import com.nytimessample.coremodules.MvpBasePresenter;
import com.nytimessample.coremodules.MvpPresenter;

/**
 * Created by Rajesh kumar on 11-11-2018.
 */

public interface DetailsPresenter extends MvpPresenter<DetailsView> {
    void setupProgressbar(ProgressBar progressBar);
    void loadWebView(String url, WebView webView);
}
