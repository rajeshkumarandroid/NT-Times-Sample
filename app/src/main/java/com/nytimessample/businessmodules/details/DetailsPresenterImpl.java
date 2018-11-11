package com.nytimessample.businessmodules.details;

import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.nytimessample.R;
import com.nytimessample.coremodules.MvpBasePresenter;
import com.nytimessample.utils.HandlingViews;
import com.nytimessample.utils.Webview_implementation;
import com.nytimessample.utils.smoothprogress.SmoothProgressDrawable;

/**
 * Created by Developer on 11-11-2018.
 */

public class DetailsPresenterImpl extends MvpBasePresenter<DetailsView> implements DetailsPresenter, HandlingViews {

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onTakeView(DetailsView view) {

    }

    @Override
    public void onDestroyView(DetailsView view) {

    }

    @Override
    public void setupProgressbar(ProgressBar progressBar) {
        progressBar.setIndeterminateDrawable(new SmoothProgressDrawable.Builder(getActivity()).interpolator(new AccelerateInterpolator()).build());
        progressBar.getIndeterminateDrawable().setColorFilter(
                getActivity().getResources().getColor(R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void loadWebView(String url, WebView webview) {
        getView().showProgressbar();
        new Webview_implementation().startWebView(url, webview, DetailsPresenterImpl.this);
    }

    @Override
    public void dialog_control() {
        getView().hideProgressbar();
    }

}
