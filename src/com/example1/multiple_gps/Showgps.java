package com.example1.multiple_gps;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Showgps extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showgps);
		Button btnShowLocation;
		btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
	    
	    // show location button click event
		//constructor
	    btnShowLocation.setOnClickListener(new View.OnClickListener() {
	         
	        @Override
	        public void onClick(View arg0) {        
	            // create class object
	            GPSTracker gps = new GPSTracker(Showgps.this);

	            // check if GPS enabled     
	            if(gps.canGetLocation()){
	                 
	                double latitude = gps.getLatitude();
	                double longitude = gps.getLongitude();
	                 
	                // \n is for new line
	                Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();    
	            }else{
	                // can't get location
	                // GPS or Network is not enabled
	                // Ask user to enable GPS/network in settings
	                gps.showSettingsAlert();
	            }
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.showgps, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
