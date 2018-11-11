package com.nytimessample.network;

import com.nytimessample.model.Result;

import java.util.List;

/**
 * Created by Developer on 13-07-2017.
 */

public interface APIResponse {
    void onSuccess(List<Result> res);

    void onFailure(Throwable t);
}
