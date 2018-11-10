package com.nytimessample.businessmodules;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimessample.DashboardActivity;
import com.nytimessample.R;
import com.nytimessample.businessmodules.detailmodule.DetailFragment;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public class DashboardFragment extends Fragment {
    View view;
    DashboardFragmentPresenter dashboardFragmentPresenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_dashboard,container,false);
        ButterKnife.bind(this,view);
        dashboardFragmentPresenter = new DashboardPresenterImpl();
        dashboardFragmentPresenter.loadItems();
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(new ItemsAdapter(getActivity(),dashboardFragmentPresenter.getItems()));
        return view;
    }
    @OnClick(R.id.imgmenu)
    void menuClickImpl(){
        (DashboardActivity.mInstance).callNavigationDrawer();
    }


    class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.CustomViewHolder> {
        private List<String> feedItemList;
        private Context mContext;

        public ItemsAdapter(Context context, List<String> feedItemList) {
            this.feedItemList = feedItemList;
            this.mContext = context;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
            CustomViewHolder viewHolder = new CustomViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder,final int i) {
            customViewHolder.textView.setText(feedItemList.get(i));
            customViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    HashMap<String,String> itemData = new HashMap<>();
                    itemData.put("Item_name",feedItemList.get(i));
                    fragmentTransaction.replace(R.id.bookfragmentcontianer,DetailFragment.getInstance(itemData)).commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return (null != feedItemList ? feedItemList.size() : 0);
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            protected TextView textView;

            public CustomViewHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.title);
            }

        }
    }
}
