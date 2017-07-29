package com.codepath.powernest;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.powernest.fragment.FilterDialogFragment;
import com.codepath.powernest.fragment.StarClubFragment;


public class HomeEventActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    ViewPager vpPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_event);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        setupDrawerContent(nvDrawer);

        getSupportActionBar().setTitle("Power Lobby");
        vpPager = (ViewPager) findViewById(R.id.vpPager);
        vpPager.setAdapter(new EventsPageAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(vpPager);


    }

    public class EventsPageAdapter extends FragmentPagerAdapter {
        private String tabTitle[] =  new String[]{"Your Group","All Group"};

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
                StarClubFragment strFragment = new StarClubFragment ();
                return strFragment;
            } else {
                StarClubFragment strFragment = new StarClubFragment ();
                return strFragment;
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

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }*/



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
            case R.id.nav_group:
                fragmentClass = PowerGroupActivity.class;
                Toast.makeText(this,"You are currently at your Homepage",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rush:
                Intent in = new Intent(this,PowerRushActivity.class);
                startActivity(in);
                break;
            case R.id.nav_setting:
                Toast.makeText(this,"You are currently at your Homepage",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_notification:
                fragmentClass = HomeEventActivity.class;
                break;

            default:
                fragmentClass = HomeEventActivity.class;

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }



    public void searchOnMap(MenuItem v){
        Intent i = new Intent(this,SearchOnMapActivity.class);
        startActivity(i);

    }

    public void filter(MenuItem v){
        Intent i = new Intent(this,SearchOnMapActivity.class);
        startActivity(i);

    }

    public void showFilterDialog(){
        FragmentManager fm = getSupportFragmentManager();
        FilterDialogFragment fragment = FilterDialogFragment.newInstance("Some Title");
        fragment.show(fm,"fragment_edit_name");

    }

    public boolean showDialog(){
        return true;
    }



}
