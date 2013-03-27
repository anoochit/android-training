package com.example.getcurrentlocation;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {

	TextView txtLat,txtLon,txtProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtLat = (TextView) findViewById(R.id.textView2);
		txtLon = (TextView) findViewById(R.id.textView3);
		txtProvider = (TextView) findViewById(R.id.textView1);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);
		Location location = locationManager.getLastKnownLocation(provider);
		
		if (location!=null) {
			txtProvider.setText(provider);
			onLocationChanged(location);
		} else {
			txtLat.setText("location not available");
			txtLon.setText("location not available");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		float lat = (float) location.getLatitude();
		float lon = (float) location.getLongitude();		
		txtLat.setText(String.valueOf(lat));
		txtLon.setText(String.valueOf(lon));		
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disable provider : " + provider , Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enable new provider : " + provider , Toast.LENGTH_SHORT).show();		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
