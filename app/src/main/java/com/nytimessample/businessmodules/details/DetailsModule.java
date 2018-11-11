package com.nytimessample.businessmodules.details;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Developer on 11-11-2018.
 */
@Module
public class DetailsModule {
    @Provides
    DetailsPresenter getPresenter(){
        return new DetailsPresenterImpl();
    }
}
