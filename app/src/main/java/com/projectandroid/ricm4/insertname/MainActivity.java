package com.projectandroid.ricm4.insertname;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectandroid.ricm4.insertname.dummy.DummyContent;

import java.io.IOException;
import java.util.List;


/**
 * Created by Jérémy Zhang on 04/01/2015.
 */

public class MainActivity extends Activity {
    private LocationManager locationManager;
    private Location location;
    private Geocoder geocoder;
    private List<Address> addresses;
    private Address address;
    private String myCityName;
    EditText cityname;
    EditText moviename;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        cityname = (EditText) findViewById(R.id.cityname);
        moviename = (EditText) findViewById(R.id.moviename);

        Button buttonHoraire = (Button) findViewById(R.id.moviebutton);
        Button buttonCinema = (Button) findViewById(R.id.citybutton);
        Button buttonGPS = (Button) findViewById(R.id.gpsbutton);
        //get location
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //get address
        geocoder = new Geocoder(this);
        myCityName="";
        addresses=null;
        address=null;
        setAddress(location);
        setName();
        //trace location
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000, 8, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        setAddress(location);
                        setName();
                    }
                    @Override
                    public void onProviderDisabled(String provider) {
                        setAddress(null);
                        setName();
                    }
                    @Override
                    public void onProviderEnabled(String provider) {
                        setAddress(locationManager.getLastKnownLocation(provider));
                        setName();
                    }
                    @Override
                    public void onStatusChanged(String provider, int status,Bundle extras) {}
                });
        buttonHoraire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), ItemListActivity.class);

                Informations.setFilm(moviename.getText().toString());
                Informations.setVille(cityname.getText().toString());

                Informations.setFonc(Informations.Fonc.HORAIRE);

                startActivity(nextScreen);
            }
        });

        buttonCinema.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), ItemListActivity.class);

                cityname = (EditText) findViewById(R.id.cityname);

                Informations.setVille(cityname.getText().toString());
                Informations.setFonc(Informations.Fonc.CINEMA);

                startActivity(nextScreen);
            }
        });

        buttonGPS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), ItemListActivity.class);

                Informations.setVille(myCityName);
                Informations.setFonc(Informations.Fonc.CINEMA);
                startActivity(nextScreen);
            }
        });
    }
    private void setAddress(Location location){
        if(location!=null){
            try {
                addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            } catch (IOException e) {
                Log.e("Address get failed", e.toString());
            }
            if(addresses == null || addresses.isEmpty()){address=null;}
            else{address = addresses.get(0);}
        }
    }
    private void setName(){
        if(address != null){myCityName=address.getLocality();}
        else{myCityName="No GPS";}
    }
}
