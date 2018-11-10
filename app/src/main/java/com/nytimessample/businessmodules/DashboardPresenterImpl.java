package com.nytimessample.businessmodules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public class DashboardPresenterImpl implements DashboardFragmentPresenter {
    //for temp purpose
    String[] temp_items = {"Apple","Banana","Orange","Graps","sapota"};

    @Override
    public void loadItems() {

    }

    @Override
    public List<String> getItems() {
        return  new ArrayList<>(Arrays.asList(temp_items));
    }





}
