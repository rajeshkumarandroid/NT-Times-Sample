package com.nytimessample.businessmodules;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nytimessample.DashboardActivity;
import com.nytimessample.R;
import com.nytimessample.businessmodules.details.DetailsActivity;
import com.nytimessample.model.Result;
import com.nytimessample.network.CallbackService;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Developer on 10-11-2018.
 */

public class DashboardFragment extends Fragment implements CallbackService,DashboardView {
    View view;
    DashboardFragmentPresenter dashboardFragmentPresenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    ProgressDialog mProgressdialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_dashboard,container,false);
        ButterKnife.bind(this,view);
        dashboardFragmentPresenter = new DashboardPresenterImpl(DashboardFragment.this,this);
        setupProgressdialog();
        dashboardFragmentPresenter.loadItems();
        prepareListItems();
        return view;
    }
    @OnClick(R.id.imgmenu)
    void menuClickImpl(){
        (DashboardActivity.mInstance).callNavigationDrawer();
    }

    @Override
    public void callBackActivity(List<Result> response) {
        recyclerview.setAdapter(new ItemsAdapter(getActivity(),response));
    }

    private void setupProgressdialog(){
        mProgressdialog = new ProgressDialog(getActivity());
        mProgressdialog.setCancelable(false);
    }

    private void prepareListItems(){
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showProgressDialog() {
        mProgressdialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressdialog.dismiss();
    }


    class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.CustomViewHolder> {
        private List<Result> feedItemList;
        private Context mContext;

        public ItemsAdapter(Context context, List<Result> feedItemList) {
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
            final String name = feedItemList.get(i).getTitle();
            customViewHolder.txtHeader.setText(name);
            customViewHolder.txtDate.setText(feedItemList.get(i).getPublishedDate());

            customViewHolder.txtSource.setText(feedItemList.get(i).getSource());
            customViewHolder.txtByLine.setText(feedItemList.get(i).getByline());
            Picasso.with(getActivity())
                    .load(feedItemList.get(i).getMedia().get(0).getMediaMetadata().get(0).getUrl())
                    .into(customViewHolder.imgArticleIcon);
            customViewHolder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), DetailsActivity.class);
                    intent.putExtra("Item url",feedItemList.get(i).getUrl());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return (null != feedItemList ? feedItemList.size() : 0);
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            private TextView txtHeader;
            private TextView txtDate;
            private ImageView imgArticleIcon;
            private View layout;
            private TextView txtSource;
            private TextView txtByLine;
            public CustomViewHolder(View view) {
                super(view);
                layout = view;
                txtHeader = (TextView) view.findViewById(R.id.title);
                imgArticleIcon = (ImageView) view.findViewById(R.id.img_article_icon);
                txtDate = (TextView) view.findViewById(R.id.date);
                txtSource = (TextView) view.findViewById(R.id.source);
                txtByLine = (TextView) view.findViewById(R.id.byLine);

            }

        }
    }
}
