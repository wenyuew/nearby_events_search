package com.laioffer.eventreporter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class EventActivity extends AppCompatActivity {
    private Fragment mEventsFragment;
    private Fragment mEventMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        if (mEventsFragment == null) {
            mEventsFragment = new EventsFragment();
        }
        getSupportFragmentManager().beginTransaction().
                add(R.id.relativelayout_event, mEventsFragment).commit();


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        // Set Item click listener to the menu items
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_event_list:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.relativelayout_event,
                                                mEventsFragment).commit();
                                break;
                            case R.id.action_event_map:
                                if (mEventMapFragment == null) {
                                    mEventMapFragment = new EventMapFragment();
                                }
                                mEventMapFragment = new EventMapFragment();

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.relativelayout_event,
                                                mEventMapFragment).commit();

                        }
                        return false;
                    }
                });


    }

}
