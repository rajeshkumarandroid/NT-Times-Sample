package com.nytimessample.network;

import com.nytimessample.model.Result;

import java.util.List;

public interface CallbackService {
    void callBackActivity(List<Result> response);
}
