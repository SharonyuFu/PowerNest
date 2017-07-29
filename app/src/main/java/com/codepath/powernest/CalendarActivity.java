package com.codepath.powernest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CalendarView;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.powernest.fragment.StarClubFragment;

public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CalendarView cdView;
    ViewPager vpPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.calerdar);

        vpPager = (ViewPager) findViewById(R.id.vpPager_cal);
        vpPager.setAdapter(new EventsPageAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(vpPager);

    }

    private class EventsPageAdapter extends FragmentPagerAdapter {
        private String tabTitle[] =  new String[]{"Your Group","All Group"};

        public EventsPageAdapter (FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                StarClubFragment strFragment = new StarClubFragment();
                return strFragment;
            }else{
                StarClubFragment strFragment = new StarClubFragment();
                return strFragment; //now is using the same page to present
            }
        }

        @Override
        public int getCount() {
            return tabTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitle[position];
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }
}
