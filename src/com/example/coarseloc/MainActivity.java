package com.example.coarseloc;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

import android.util.Log;

public class MainActivity extends ActionBarActivity implements LocationListener{
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	protected Context context;
	TextView txtLat;
	String lat;
	String provider;
	protected String latitude,longitude; 
	protected boolean gps_enabled,network_enabled;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	txtLat = (TextView) findViewById(R.id.textview1);

	locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
	}
	@Override
	public void onLocationChanged(Location location) {
	txtLat = (TextView) findViewById(R.id.textview1);
	txtLat.setText("Latitude is:" + location.getLatitude() + ", Longitude is:" + location.getLongitude());
	}

	@Override
	public void onProviderDisabled(String provider) {
	Log.d("Latitude","disable");
	}

	@Override
	public void onProviderEnabled(String provider) {
	Log.d("Latitude","enable");
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	Log.d("Latitude","status");
	}
	}