package com.example1.multiple_gps;
import android.content.Intent;
//An intent is an abstract description of an operation to be performed
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
//A primary toolbar within the activity that may display the activity title,
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	

	public void anything(View v)
	{
	EditText user=(EditText) findViewById(R.id.username);
	EditText pass=(EditText) findViewById(R.id.password);
	if(user.getText().toString().equals(pass.getText().toString()))
	{
	Toast tst=Toast.makeText(getApplicationContext(), "Login Successful", 00);
	tst.show();
	android.content.Intent intent1 = new android.content.Intent(this, Activity2.class);
	startActivityForResult(intent1,0);
	}
	else
	{
	Toast tst=Toast.makeText(getApplicationContext(), "Login UnSuccessful", 300);
	tst.show();
	}
	}
	public void anything1(View v)
	{
	//EditText reg=(EditText) findViewById(R.id.register);
	Intent intent = new Intent(MainActivity.this, Register.class);
	startActivityForResult(intent,0);
	}
	public void anything2(View v)
	{
	//EditText gp=(EditText) findViewById(R.id.register);
	Intent intent = new Intent(MainActivity.this, Showgps.class);
	startActivityForResult(intent,0);
	}
	
	public void rgbutton(View k)
	{
	EditText pass=(EditText) findViewById(R.id.getPass);
	//EditText cnfrm=(EditText) findViewById(R.id.conPass);
	//if(pass.getText().toString().equals(cnfrm.getText().toString()))
	{
	Toast tst=Toast.makeText(getApplicationContext(), " ", 00);
	tst.show();
	}
	//else
	{
	Toast tst=Toast.makeText(getApplicationContext(), "Password did't match", 300);
	tst.show();
	}

	}
	

}
