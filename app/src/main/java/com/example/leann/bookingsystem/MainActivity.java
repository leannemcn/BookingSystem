package com.example.leann.bookingsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static com.example.leann.bookingsystem.R.string.booking_tab_close;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.booking_layout);
        NavigationView menuTab = findViewById(R.id.frame_view);
        menuTab.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(  this, button, toolbar,
        R.string.booking_tab_open, booking_tab_close);
        button.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) //this will allow device to be rotated
        { getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                new HomePage()).commit();
        menuTab.setCheckedItem(R.id.nav_home);}

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home: getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new HomePage()).commit();
                break;
            case R.id.nav_profile: getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new ProfilePage()).commit();
                break;
            case R.id.nav_gallery: getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new GalleryPage()).commit();
                break;
            case R.id.nav_calendar: getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new CalendarPage()).commit();
                break;
            case R.id.nav_contact: getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new ContactUsPage()).commit();
                break;
        }
        button.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (button.isDrawerOpen(GravityCompat.START)) {
            button.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed(); //this will close the navigation tab once pressed
        }
    }


}



