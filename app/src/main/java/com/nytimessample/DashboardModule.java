package com.nytimessample;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Developer on 10-11-2018.
 */
@Module
public class DashboardModule {
    @Provides
    DashBoardPresenter getPresenter(){
        return new DashboardImpl();
    }
}
