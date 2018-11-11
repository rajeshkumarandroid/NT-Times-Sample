package com.nytimessample.utils;

import android.content.Context;


import com.nytimessample.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Developer on 13-07-2017.
 */

public class Dashboard_items {


    protected  String[] titles;
    ArrayList<HashMap<String ,Object >> data = new ArrayList<>();
    Integer mhomeIcons[] = {R.mipmap.ic_launcher};
    public Dashboard_items(Context context){

        titles = context.getResources().getStringArray(R.array.dashboard_items_menu);

    }
    public ArrayList<HashMap<String ,Object >> getDashBoardItems(){
       for (int i = 0;i<titles.length;i++){
           HashMap<String,Object > items = new HashMap<>();
           items.put("title",titles[i]);
           items.put("image",mhomeIcons[i]);
           data.add(items);
       }
        return data;
    }
}
