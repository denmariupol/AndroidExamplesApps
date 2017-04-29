package com.example.mapsgps.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.mapsgps.R;
import com.example.mapsgps.fragments.MainFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleApiClient googleApiClient;
    private final int PERMISSION_LOCATION = 111;
    private MainFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        googleApiClient = new GoogleApiClient.Builder(this)//create builder
                .enableAutoManage(this, this)//enable automanage lifecycle which start in onStart and ends in onStop
                .addConnectionCallbacks(this)//add listener for receiving callback
                .addApi(LocationServices.API)//add API which will interacting with client
                .build();//build

        fragment = MainFragment.newInstance();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }

    //called by google api when its connected  in googleApiClient.connect();
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //checking for  permission ,if it don't exist requesting it
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_LOCATION );
            Log.d("!!!","requestPermissions");
        }else{//if permission was given in previous session
            startLocationServices();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("!!!","Long: "+ location.getLongitude()+" -Lat: "+location.getLatitude());
        fragment.setUserMarkers(new LatLng(location.getLatitude(),location.getLongitude()));
    }
    //Callback for the result from requesting permissions. This method is invoked for every call on requestPermissions(String[], int)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_LOCATION:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startLocationServices();
                }else{
                    //show a dialog saying "I cant run you location-you denied permission"
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }


    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    public void startLocationServices() {
        Log.d("!!!", "startLocationServices");
        LocationRequest request = LocationRequest.create()//Create a location request with default parameters.
                .setPriority(LocationRequest.PRIORITY_LOW_POWER);/**Set the priority of the request.
                                                                                PRIORITY_BALANCED_POWER_ACCURACY 	Used with setPriority(int) to request "block" level accuracy.
                                                                                PRIORITY_HIGH_ACCURACY 	Used with setPriority(int) to request the most accurate locations available.
                                                                                PRIORITY_LOW_POWER 	Used with setPriority(int) to request "city" level accuracy.
                                                                                PRIORITY_NO_POWER 	Used with setPriority(int) to request the best accuracy possible with zero additional power consumption.
**/
                try {
                    LocationServices.FusedLocationApi//Entry point to the fused location APIs.
                            .requestLocationUpdates(googleApiClient, request, this);//Register for a single location update using a Criteria and pending intent.
                }catch (SecurityException ex){
                    // show dialog to user  that we cant show his location until he give permission
                    Log.d("!!!", "SecurityException");
                }
    }
}
