package com.nytimessample.di;

import com.nytimessample.businessmodules.details.DetailsActivity;
import com.nytimessample.businessmodules.details.DetailsModule;

import dagger.Subcomponent;

/**
 * Created by Developer on 11-11-2018.
 */
@Subcomponent(modules = DetailsModule.class)
public interface DetailsComponent {
    void inject(DetailsActivity detailsActivity);
}
