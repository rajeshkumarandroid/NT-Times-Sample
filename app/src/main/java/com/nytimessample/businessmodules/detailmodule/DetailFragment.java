package com.nytimessample.businessmodules.detailmodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimessample.R;
import com.nytimessample.businessmodules.DashboardFragment;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public class DetailFragment extends Fragment{

    @BindView(R.id.txt_itemValue)
    TextView mtxt_itemName;
    public static DetailFragment getInstance(HashMap<String,String> data){
        DetailFragment dashboardFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Item name",data.get("Item_name"));
        dashboardFragment.setArguments(bundle);
        return dashboardFragment;
    }


    View view;
    String mItem_name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmentdetail,container,false);
        ButterKnife.bind(this,view);
        mtxt_itemName.setText(mItem_name);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mItem_name = getArguments().getString("Item name");
                Log.e("item name is ","<>>"+mItem_name);
    }
}
