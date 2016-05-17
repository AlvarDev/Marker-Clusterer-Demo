package com.alvardev.android.markerclustererdemo.entities;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by AlvarDev on 5/17/16.
 * for I/O Extended 2016
 **/
public class MyMarker implements ClusterItem {
    private final LatLng mPosition;

    public MyMarker(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}