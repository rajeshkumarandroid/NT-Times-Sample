package com.nytimessample.businessmodules.details;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.nytimessample.R;
import com.nytimessample.coremodules.MvpBaseActivity;
import com.nytimessample.di.DetailsComponent;
import com.nytimessample.utils.smoothprogress.SmoothProgressDrawable;

import butterknife.BindView;

/**
 * Created by Developer on 11-11-2018.
 */

public class DetailsActivity extends MvpBaseActivity<DetailsPresenter, DetailsComponent> implements DetailsView {
    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressbar;

    @Override
    public int getLayout() {
        return R.layout.fragmentdetail;
    }

    @Override
    protected DetailsComponent setupActivityComponent() {
        return getApplicationComponent().plus(new DetailsModule());
    }

    @Override
    protected void onCreateAfterSetContentView(Bundle savedInstanceState) {
        super.onCreateAfterSetContentView(savedInstanceState);
        String url = getIntent().getExtras().getString("Item url");
        getPresenter().setupProgressbar(mProgressbar);
        getPresenter().loadWebView(url, mWebView);
    }

    @Override
    public void showProgressbar() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mProgressbar.setVisibility(View.GONE);

    }
}
