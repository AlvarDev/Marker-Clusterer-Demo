package com.alvardev.android.markerclustererdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.alvardev.android.markerclustererdemo.entities.MyMarker;
import com.alvardev.android.markerclustererdemo.util.Util;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

public class MapsWithActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Toolbar toolbar;
    private GoogleMap mMap;
    /**
     *  Declare a variable for the cluster manager.
     **/
    private ClusterManager<MyMarker> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_with);

        setUI();
        setToolbar(getString(R.string.s_with));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setUI(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar(String name){
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mClusterManager = new ClusterManager<>(this, mMap);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-25.433034, -49.275836))      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);

        setMarkers();
    }

    private void setMarkers(){
        List<MyMarker> myMarkers = Util.getMarkers();

        for (MyMarker marker : myMarkers) {
            mClusterManager.addItem(marker);
        }
    }



}
