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

import com.codepath.powernest.adapter.challengeAdapter;
import com.codepath.powernest.model.Challenge;
import com.codepath.powernest.model.User;

import java.util.List;

public class PowerRushActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private CardView cdView;
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





        }



    }




}
