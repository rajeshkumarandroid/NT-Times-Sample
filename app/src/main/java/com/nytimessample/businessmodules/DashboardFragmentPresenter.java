package com.nytimessample.businessmodules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public interface DashboardFragmentPresenter {
    void loadItems();
    List<String> getItems();
}
