package com.codepath.powernest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class GropuDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView fakeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_detail_fake);

        fakeImg = (ImageView)findViewById(R.id.GroupDetail);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Group Manager");
    }
}



