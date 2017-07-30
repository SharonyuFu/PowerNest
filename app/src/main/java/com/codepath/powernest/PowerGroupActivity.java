package com.codepath.powernest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.design.widget.NavigationView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.powernest.adapter.ClubAdapter;
import com.codepath.powernest.fragment.GroupManagerFragment;
import com.codepath.powernest.fragment.StarClubFragment;
import com.codepath.powernest.model.Club;

import java.util.ArrayList;
import java.util.List;

public class PowerGroupActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private ListView lvPowerGroup;
    private List<Club> clubs = new ArrayList<>();
    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private ViewPager vpPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_group);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Power Group");


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        setupDrawerContent(nvDrawer);
        vpPager = (ViewPager) findViewById(R.id.vpPager);
        vpPager.setAdapter(new EventsPageAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(vpPager);

    }

    public class EventsPageAdapter extends FragmentPagerAdapter {
        private String tabTitle[] =  new String[]{"Group Manager","Favorite Group"};

        public EventsPageAdapter (FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return tabTitle.length;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                GroupManagerFragment gmFragment = new GroupManagerFragment ();
                return gmFragment;
            } else {
                GroupManagerFragment gmFragment = new GroupManagerFragment ();
                return gmFragment;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitle[position];
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked

        switch(menuItem.getItemId()) {

            case R.id.nav_lobby:
                Intent i = new Intent(getApplicationContext(),HomeEventActivity.class);
                startActivity(i);
                break;
            case R.id.nav_calendar:
                Intent j = new Intent(this,CalendarActivity.class);
                startActivity(j);
                break;
            case R.id.nav_group_manager:
                Intent jo = new Intent(this,PowerGroupActivity.class);
                startActivity(jo);
                break;
            case R.id.nav_rush:
                Intent in = new Intent(this,PowerRushActivity.class);
                startActivity(in);
                break;
            case R.id.nav_setting:
                Toast.makeText(this,"You are currently at your Homepage",Toast.LENGTH_SHORT).show();
                break;
        }


    }







}
