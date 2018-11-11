package com.nytimessample.businessmodules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.nytimessample.model.Result;
import com.nytimessample.network.APIResponse;
import com.nytimessample.network.CallbackService;
import com.nytimessample.network.EndPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Developer on 10-11-2018.
 */

public class DashboardPresenterImpl implements DashboardFragmentPresenter {

    Fragment mContext;
    DashboardView mView;

    DashboardPresenterImpl(Fragment context,DashboardView view) {
        mContext = context;
        this.mView = view;
    }
    @Override
    public void loadItems() {
        mView.showProgressDialog();
        new EndPoint().getResult(new APIResponse() {
            @Override
            public void onSuccess(List<Result> res) {
                Log.e("response is ", "<><>" + res);
                mView.hideProgressDialog();
                ((CallbackService) mContext).callBackActivity(res);
            }
            @Override
            public void onFailure(Throwable t) {
            }
        });
    }
}
