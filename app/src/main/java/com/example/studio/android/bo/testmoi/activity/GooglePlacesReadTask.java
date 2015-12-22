package com.example.studio.android.bo.testmoi.activity;

import android.os.AsyncTask;
import android.util.Log;

import com.example.studio.android.bo.testmoi.utils.Http;
import com.google.android.gms.maps.GoogleMap;

import java.util.Objects;

/**
 * Created by User on 12/22/2015.
 */
public class GooglePlacesReadTask extends AsyncTask<Object, Integer, String> {

    String googlePlacesData = null;
    GoogleMap mMap;

    @Override
    protected String doInBackground(Object... params) {
        try {

            mMap = (GoogleMap)params[0];
            String googlePlacesUrl = (String) params[1];
            Http http = new Http();
            googlePlacesData = http.read(googlePlacesUrl);
        }catch (Exception e){
            Log.d("Google Place Read Task", e.toString());

        }

        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s) {
        PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask();
        Object[] toPass = new Object[2];
        toPass[0] = mMap;
        toPass[1] = s;
        placesDisplayTask.execute(toPass);


    }
}
