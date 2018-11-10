package com.nytimessample.components;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public class NYTimesSample extends NYTimesBase {
    @Override
    protected NYTimesComponet createApplicationComponent() {
        return DaggerNYTimesComponet.builder()
                .nYTimesModule(new NYTimesModule(NYTimesSample.this))
                .build();
    }
}
