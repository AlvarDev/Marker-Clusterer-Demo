package com.alvardev.android.markerclustererdemo.util;

import com.alvardev.android.markerclustererdemo.entities.MyMarker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlvarDev on 5/17/16.
 * for I/O Extended 2016
 **/
public class Util {

    public static List<MyMarker> getMarkers(){
        List<MyMarker> markers = new ArrayList<>();
        markers.add(new MyMarker(-25.433686, -49.275978));
        markers.add(new MyMarker(-25.433876, -49.276189));
        markers.add(new MyMarker(-25.433580, -49.277508));
        markers.add(new MyMarker(-25.433191, -49.277566));
        markers.add(new MyMarker(-25.432732, -49.276369));
        markers.add(new MyMarker(-25.431969, -49.277136));
        markers.add(new MyMarker(-25.432015, -49.275654));
        markers.add(new MyMarker(-25.432707, -49.274852));
        markers.add(new MyMarker(-25.433375, -49.274155));
        markers.add(new MyMarker(-25.431609, -49.275075));
        markers.add(new MyMarker(-25.432054, -49.273709));
        markers.add(new MyMarker(-25.434088, -49.276917));
        markers.add(new MyMarker(-25.434721, -49.278638));
        markers.add(new MyMarker(-25.430934, -49.273447));
        return markers;
    }


}
