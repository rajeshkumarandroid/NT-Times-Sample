package com.nytimessample.businessmodules.details;

import com.nytimessample.coremodules.MvpView;

/**
 * Created by Rajesh kumar on 11-11-2018.
 */

public interface DetailsView extends MvpView<DetailsPresenter> {
    void showProgressbar();
    void hideProgressbar();
}
