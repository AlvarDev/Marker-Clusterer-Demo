package com.alvardev.android.markerclustererdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.alvardev.android.markerclustererdemo.entities.MyMarker;
import com.alvardev.android.markerclustererdemo.util.Util;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsWithoutActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_without);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker
        LatLng sydney = new LatLng(-25.433034, -49.275836);
        mMap.addMarker(new MarkerOptions().position(sydney).title(getString(R.string.s_positivo_university)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-25.433034, -49.275836))      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        setMarkers();
    }

    private void setMarkers(){
        List<MyMarker> myMarkers = Util.getMarkers();

        for (MyMarker marker : myMarkers) {
            mMap.addMarker(new MarkerOptions().position(marker.getPosition()).title(getString(R.string.s_beer)));
        }
    }

}
