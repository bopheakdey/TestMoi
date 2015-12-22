package com.example.studio.android.bo.testmoi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.studio.android.bo.testmoi.activity.MapsActivity;
import com.example.studio.android.bo.testmoi.activity.NearbyPlaceActivity;
import com.example.studio.android.bo.testmoi.activity.SearchLocation;
import com.example.studio.android.bo.testmoi.adapter.PagerAdapter;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    public ViewPager viewPager;
    private FloatingActionButton fab;

    public ViewPager getViewPager(){
        return viewPager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.vp);
        PagerAdapter p = new PagerAdapter(getApplicationContext(), getSupportFragmentManager());
        viewPager.setAdapter(p);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0,true);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switchTabIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/CooperHewitt-Light.otf");


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Intent i = new Intent(getApplicationContext(), SearchLocation.class);
//                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                Intent i = new Intent(getApplicationContext(), NearbyPlaceActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupTabIcons();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.home_black);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat_white);
        tabLayout.getTabAt(2).setIcon(R.drawable.heart_white);
    }


    private void switchTabIcon(int position) {
        switch (position) {
            case 0:
                fab.setVisibility(View.VISIBLE);
                tabLayout.getTabAt(0).setIcon(R.drawable.home_black);
                tabLayout.getTabAt(1).setIcon(R.drawable.chat_white);
                tabLayout.getTabAt(2).setIcon(R.drawable.heart_white);
                break;
            case 1:
                fab.setVisibility(View.GONE);
                tabLayout.getTabAt(0).setIcon(R.drawable.home_white);
                tabLayout.getTabAt(1).setIcon(R.drawable.chat_black);
                tabLayout.getTabAt(2).setIcon(R.drawable.heart_white);
                break;
            case 2:
                fab.setVisibility(View.GONE);
                tabLayout.getTabAt(0).setIcon(R.drawable.home_white);
                tabLayout.getTabAt(1).setIcon(R.drawable.chat_white);
                tabLayout.getTabAt(2).setIcon(R.drawable.heart_black);
                break;
        }

    }
}
