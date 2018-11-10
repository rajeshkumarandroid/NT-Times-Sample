package com.nytimessample.di;

import com.nytimessample.DashboardActivity;
import com.nytimessample.DashboardModule;

import dagger.Subcomponent;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */
@Subcomponent(modules = DashboardModule.class)
public interface DashboardComponent {
    void inject(DashboardActivity dashboardActivity);
}
