package com.codepath.powernest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class SearchOnMapActivity extends AppCompatActivity {

    ImageView mapImg;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_on_map);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Search Nearby Events");

        mapImg = (ImageView)findViewById(R.id.imageView2);
//        Picasso.with(this).load(R.drawable.fake_search).resize(432, 512).
//                centerCrop().into(mapImg);
    }
}
