package com.nytimessample.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nytimessample.businessmodules.details.DetailsPresenterImpl;

/**
 * Created by ChRajeshKumar on 10/18/2016.
 */

public class Webview_implementation {
    public void startWebView(String url, WebView webview, final DetailsPresenterImpl context) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setAppCacheEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webview.getSettings().setSavePassword(true);
        webview.getSettings().setSaveFormData(true);
        webview.getSettings().setEnableSmoothTransition(true);
        webview.getSettings().setSupportZoom(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setDatabaseEnabled(true);
        webview.getSettings().setLightTouchEnabled(true);
        webview.getSettings().setSupportMultipleWindows(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


            public void onPageFinished(WebView view, String url) {
                try {
                    HandlingViews handlingViews = (HandlingViews)context;
                    handlingViews.dialog_control();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        });

        if (Build.VERSION.SDK_INT >= 19) {
            webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webview.loadUrl(url);
    }
}
