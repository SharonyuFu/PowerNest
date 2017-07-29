package com.codepath.powernest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class EventDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView fakeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fack_detail_page);

        fakeImg = (ImageView)findViewById(R.id.fakeDetail);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Friday, 2017-07-31");
    }
}
