package com.example.studio.android.bo.testmoi.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studio.android.bo.testmoi.MainActivity;
import com.example.studio.android.bo.testmoi.R;
import com.example.studio.android.bo.testmoi.utils.GPSService;

public class CurrentLocationText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        TextView tv = (TextView)findViewById(R.id.txt);


        String address = "";
        GPSService mGPSService = new GPSService(CurrentLocationText.this);
        mGPSService.getLocation();

        if (mGPSService.isLocationAvailable == false) {

            // Here you can ask the user to try again, using return; for that
            Toast.makeText(getApplicationContext(), "Your location is not available, please try again.", Toast.LENGTH_SHORT).show();
            return;

            // Or you can continue without getting the location, remove the return; above and uncomment the line given below
            // address = "Location not available";
        } else {

            // Getting location co-ordinates
            double latitude = mGPSService.getLatitude();
            double longitude = mGPSService.getLongitude();
            Toast.makeText(getApplicationContext(), "Latitude:" + latitude + " | Longitude: " + longitude, Toast.LENGTH_LONG).show();

            address = mGPSService.getLocationAddress();
        }
        tv.setText("Location: "+ address);

    }

}
