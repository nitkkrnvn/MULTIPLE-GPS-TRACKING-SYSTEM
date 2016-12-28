package com.example1.multiple_gps;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Activity2 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
	}
	
	public void any(View v)
	{
	//EditText reg=(EditText) findViewById(R.id.register);
	Intent intent = new Intent(Activity2.this, ToShowGps.class);
	startActivityForResult(intent,0);
	}

	public void any1(View v)
	{
	//EditText reg=(EditText) findViewById(R.id.register);
	Intent intent = new Intent(Activity2.this, About_Us.class);
	startActivityForResult(intent,0);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity2, menu);
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
