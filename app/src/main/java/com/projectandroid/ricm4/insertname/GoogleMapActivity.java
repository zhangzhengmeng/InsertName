package com.projectandroid.ricm4.insertname;

//import com.google.android.maps.MapActivity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by hugo on 06/01/15.
 */
public class GoogleMapActivity extends Activity {

    //private MapViewiew mapView;

    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        //mapView = (MapView) this.findViewById(R.id.mapView);
        //mapView.setBuiltInZoomControls(true);
    }

    //@Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}