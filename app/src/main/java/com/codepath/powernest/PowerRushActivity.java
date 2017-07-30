package com.codepath.powernest;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.powernest.adapter.LikedClubAdapter;
import com.codepath.powernest.adapter.challengeAdapter;
import com.codepath.powernest.model.Challenge;
import com.codepath.powernest.model.User;

import java.util.List;

public class PowerRushActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView rvChallen;
    private List<Challenge> challen;
    private challengeAdapter chAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            setContentView(R.layout.activity_power_rush);

            toolbar = (Toolbar)findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Power Rush");

            rvChallen = (RecyclerView)findViewById(R.id.rvChallenge);
            rvChallen.setHasFixedSize(true);
            // Define 2 column grid layout
            final LinearLayoutManager layout = new LinearLayoutManager(this);

            rvChallen.setLayoutManager(layout);

            // get data
            challen = Challenge.getChallenges();


            // Create an adapter
            chAdapter = new challengeAdapter(PowerRushActivity.this, challen);

            // Bind adapter to list
            rvChallen.setAdapter(chAdapter);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            nvDrawer = (NavigationView) findViewById(R.id.nvView);
            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                    R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(drawerToggle);

            setupDrawerContent(nvDrawer);

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
