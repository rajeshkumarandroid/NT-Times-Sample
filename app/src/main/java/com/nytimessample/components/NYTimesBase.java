package com.nytimessample.components;

import android.app.Application;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public abstract class NYTimesBase extends Application {
    private static NYTimesBase sInstance;
    NYTimesComponet nyTimesComponet;
    protected abstract NYTimesComponet createApplicationComponent();
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        configureComponent();
    }

    private void configureComponent(){
        nyTimesComponet = createApplicationComponent();
    }

    public NYTimesComponet getNyTimesComponet() {
        return nyTimesComponet;
    }
}
