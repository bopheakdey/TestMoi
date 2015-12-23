package com.example.studio.android.bo.testmoi.activity;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.studio.android.bo.testmoi.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements LocationListener{//implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//

//        show error dialog if GooglePlayServices not available
        if(!isGooglePlayServicesAvailable()){
            finish();
        }
        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mMap = supportMapFragment.getMap();
        try {
            mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
            if(location != null){
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        }catch (SecurityException e){
            e.printStackTrace();
            Log.d("bug", e.getMessage());
        }
    }

        @Override
        public void onLocationChanged(Location location) {
            TextView locationTv = (TextView) findViewById(R.id.latlongLocation);
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
//            locationTv.setText("Latitude: "+ latitude + ", Longitude: "+ longitude);
            locationTv.setText("Location: "+ getLocationAddress(latitude, longitude));

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(ConnectionResult.SUCCESS == status){
            return true;
        }else{
            GooglePlayServicesUtil.getErrorDialog(status,this,0).show();
            return false;
        }
    }

//    public String getLocationAddress(double mLatitude, double mLongitude) {
////        if (isLocationAvailable) {
//            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
//            //Get the current location from the input parameter list
//            //Create a list to contain the result address
//            List<Address> addresses = null;
//            try {
//                /*
//                *return 1 address
//                */
//                addresses = geocoder.getFromLocation(mLatitude, mLongitude, 1);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                return ("IOException trying to get address: " + e.getMessage());
//            } catch (IllegalArgumentException e2) {
//                // Error message to post in the log
//                String errorString = "Illegal arguments "
//                        + Double.toString(mLatitude) + " , "
//                        + Double.toString(mLongitude)
//                        + " passed to address service";
//                e2.printStackTrace();
//                return errorString;
//            }
//            //if the reverse geocode returned an address
//            if (addresses != null && addresses.size() > 0) {
//                //Get the first address
//                Address address = addresses.get(0);
//                /**
//                 * Format the first line of address (if available), city, and country name.
//                 */
//                String addressText = String.format("%s,%s,%s",
//                        //if there's a street address, add it
//                        address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
//                        //Locality is usally a city
//                        address.getLocality(),
//                        //the country of the address
//                        address.getCountryName());
//                return addressText;
//            } else {
//                return "No address found by the service: Note to the developers, If no address is found by google itself, there is nothing you can do about it.";
//            }
//
////        } else {
////            return "Location Not available";
////        }
//
//    }
public String getLocationAddress(double mLatitude, double mLongitude) {
//        if (isLocationAvailable) {
    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
    //Get the current location from the input parameter list
    //Create a list to contain the result address
//        List<Address> addresses = null;
//        try {
//                /*
//                *return 1 address
//                */
//            addresses = geocoder.getFromLocation(mLatitude, mLongitude, 1);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ("IOException trying to get address: " + e.getMessage());
//        } catch (IllegalArgumentException e2) {
//            // Error message to post in the log
//            String errorString = "Illegal arguments "
//                    + Double.toString(mLatitude) + " , "
//                    + Double.toString(mLongitude)
//                    + " passed to address service";
//            e2.printStackTrace();
//            return errorString;
//        }
    //if the reverse geocode returned an address
//        if (addresses != null && addresses.size() > 0) {
//            //Get the first address
//            Address address = addresses.get(0);
    /**
     * Format the first line of address (if available), city, and country name.
     */
//            String addressText = String.format("%s,%s,%s",
//                    //if there's a street address, add it
//                    address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
//                    //Locality is usally a city
//                    address.getLocality(),
//                    //the country of the address
//                    address.getCountryName());
//                    return addressText;

    String result = null;
    try {
        List<Address> addressList = geocoder.getFromLocation(
                mLatitude, mLongitude, 1);
        if (addressList != null && addressList.size() > 0) {
            Address address = addressList.get(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                sb.append(address.getAddressLine(i)).append("\n");
            }
//            sb.append(address.getLocality()).append("\n");
//            sb.append(address.getPostalCode()).append("\n");
            sb.append(address.getCountryName());
            result = sb.toString();
            return result;
        } else {
            return "No address found by the service: Note to the developers, If no address is found by google itself, there is nothing you can do about it.";
        }
    }catch (IOException e){
        return e.getMessage();
    }

//        } else {
//            return "Location Not available";
//        }

}






        /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }




}
