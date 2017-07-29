package com.codepath.powernest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.codepath.powernest.adapter.ClubAdapter;
import com.codepath.powernest.model.Club;

import java.util.ArrayList;
import java.util.List;

public class PowerGroupActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView lvPowerGroup;
    private List<Club> clubs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_group);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Construct the data source
//        ArrayList<Club> arrayOfClubs = new ArrayList<Club>();

        clubs = Club.getClubs();
        // Create the adapter to convert the array to views
        ClubAdapter adapter = new ClubAdapter(this, clubs);


        lvPowerGroup = (ListView)findViewById(R.id.lvPowerGroup);
        lvPowerGroup.setAdapter(adapter);


        getSupportActionBar().setTitle("Group Manager");


        lvPowerGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"TEST",Toast.LENGTH_SHORT).show();
                Intent g = new Intent(getApplicationContext(), GropuDetailActivity.class);
                startActivity(g);

            }
        });

    }





}
