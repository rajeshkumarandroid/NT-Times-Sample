package com.nytimessample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.nytimessample.businessmodules.DashboardFragment;
import com.nytimessample.businessmodules.MenuCallback;
import com.nytimessample.coremodules.MvpBaseActivity;
import com.nytimessample.customviews.CustomDrawerLayout;
import com.nytimessample.customviews.ItemAdapter;
import com.nytimessample.di.DashboardComponent;
import com.nytimessample.utils.Dashboard_items;

import butterknife.BindView;

/**
 * Created by Rajesh kumar on 10-11-2018.
 */

public class DashboardActivity extends MvpBaseActivity<DashBoardPresenter, DashboardComponent> implements DashboardView,MenuCallback {

    @BindView(R.id.drawer_layout)
    CustomDrawerLayout mDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.mainlist)
    ListView mList;

    ItemAdapter mAdapter;
    public static DashboardActivity mInstance;
    @BindView(R.id.framework)
    FrameLayout mFramelayout;
    Toolbar mToolbar;

    @Override
    public int getLayout() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected DashboardComponent setupActivityComponent() {
        return getApplicationComponent().plus(new DashboardModule());
    }

    @Override
    protected void onCreateAfterSetContentView(Bundle savedInstanceState) {
        super.onCreateAfterSetContentView(savedInstanceState);
        mInstance = this;
        initilizeViews();
        implementNavigation();
    }


    private void implementNavigation() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                ActivityCompat.invalidateOptionsMenu(DashboardActivity.this);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ActivityCompat.invalidateOptionsMenu(DashboardActivity.this);
            }

        };
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (mToolbar != null) {
//            setSupportActionBar(mToolbar);
//        }
        setUpNavDrawer();
//        drawerToggle.syncState();
        mAdapter = new ItemAdapter(this, new Dashboard_items(this).getDashBoardItems());
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                mFramelayout.setVisibility(View.GONE);

                switch (position) {
                    case 0:
                        break;
                }
                navigationListProcess();
            }
        });
    }

    public void initilizeViews() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new DashboardFragment());
        transaction.addToBackStack("bookFragment");
        transaction.commit();
    }


    private void setUpNavDrawer() {
        if (mToolbar != null) {
            assert getSupportActionBar() != null;
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick(View v) {
                    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });
        }
    }

    public void navigationListProcess() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void callNavigationDrawer() {
        mFramelayout.setVisibility(View.VISIBLE);
        navigationListProcess();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        finish();
    }
}
