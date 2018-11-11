package com.nytimessample.network;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Rajesh Kumar on 15-02-2018.
 */

public class EndPoint  {
    NetworkService apiService;
    public EndPoint(){
         apiService =(RetrofitInstance.getRetrofitInstance()).create(NetworkService.class);

    }
    public void getResult(final APIResponse api_res ){

//        if(BaseActivity.haveNetworkConnection(context)){
            apiService.getArticles().enqueue(new Callback<com.nytimessample.model.Response>() {
                @Override
                public void onResponse(Call<com.nytimessample.model.Response> call, Response<com.nytimessample.model.Response> response) {
                    api_res.onSuccess(response.body().getResults());
                }

                @Override
                public void onFailure(Call<com.nytimessample.model.Response> call, Throwable t) {
                    api_res.onFailure(t);
                }
            });

//        }else{
//           RetrofitClient.getInstance().hideProgressDialog();
//            Toast.makeText(context, "please check internet connection", Toast.LENGTH_SHORT).show();
//        }


    }


}
