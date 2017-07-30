package com.codepath.powernest;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.codepath.powernest.adapter.ClubAdapter;
import com.codepath.powernest.adapter.LikedClubAdapter;
import com.codepath.powernest.model.Club;

import java.util.ArrayList;
import java.util.List;

public class LikedGroupActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ListView lvPowerGroup;
    private List<Club> clubs = new ArrayList<>();
    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_group);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Construct the data source
//        ArrayList<Club> arrayOfClubs = new ArrayList<Club>();

        clubs = Club.getClubs();
        // Create the adapter to convert the array to views
        LikedClubAdapter adapter = new LikedClubAdapter(this, clubs);


        lvPowerGroup = (ListView)findViewById(R.id.lvPowerGroup);
        lvPowerGroup.setAdapter(adapter);


        getSupportActionBar().setTitle("Liked Group");


        lvPowerGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"TEST",Toast.LENGTH_SHORT).show();
                Intent g = new Intent(getApplicationContext(), GropuDetailActivity.class);
                startActivity(g);

            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        setupDrawerContent(nvDrawer);

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
