package com.nytimessample.components;

import com.nytimessample.DashboardModule;
import com.nytimessample.di.DashboardComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */
@Singleton
@Component(modules = NYTimesModule.class)
public interface NYTimesComponet {
    DashboardComponent plus(DashboardModule dashboardModule);
}
