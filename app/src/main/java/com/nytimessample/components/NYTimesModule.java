package com.nytimessample.components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */
@Module
public class NYTimesModule {
    Application mApplication;
    public NYTimesModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public Application getApplication(){
        return mApplication;
    }
}
