package com.example1.multiple_gps;


import android.support.v7.app.ActionBarActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import android.database.sqlite.SQLiteDatabase;
public class Register  extends ActionBarActivity  {
	
	//new database
	String fname,lname,email;
	SQLiteDatabase db;
	 TableRow tableRow;
	   TextView textView,textView1,textView2,textView3,textView4,textView5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=openOrCreateDatabase("MyDB1",MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student3(fname VARCHAR primary key,lname VARCHAR,email VARCHAR);");
    }
public void data(View view)
{
  EditText edittext1=(EditText )findViewById(R.id.getUser);
  EditText edittext2=(EditText )findViewById(R.id.getPass);
  EditText edittext3=(EditText )findViewById(R.id.getEmail);
  fname=edittext1.getText().toString();
  lname=edittext2.getText().toString();
  email=edittext3.getText().toString();
  try{
  db.execSQL("INSERT INTO  student3 VALUES('"+fname+"','"+lname+"','"+email+"');");
  Toast tst=Toast.makeText(getApplicationContext(), "Registration Successful", 00);
	tst.show();
  }
  catch (Exception e)
  {
	  Toast tst=Toast.makeText(getApplicationContext(), "Registration UnSuccessful", 00);
		tst.show();  
  }
  }
	 

public void showdata(View view)
{	//it access the result returned by the sql query 
    Cursor c=db.rawQuery("SELECT * from student3", null);
    //to fetch
     int count= c.getCount();
    c.moveToFirst();
    TableLayout tableLayout = new TableLayout(getApplicationContext());
    tableLayout.setVerticalScrollBarEnabled(true);
   TableRow tableRow;
   TextView textView,textView1,textView2,textView3,textView4,textView5;
   tableRow = new TableRow(getApplicationContext());
   textView=new TextView(getApplicationContext());
   textView.setText("Email");
   textView.setTextColor(Color.RED);
   
  	textView.setTypeface(null, Typeface.BOLD);
  	 textView.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView);
    textView4=new TextView(getApplicationContext());
  	textView4.setText("Password");
  	textView4.setTextColor(Color.RED);
  	textView4.setTypeface(null, Typeface.BOLD);
  	 textView4.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView4);
    textView5=new TextView(getApplicationContext());
  	textView5.setText("Name");
  	textView5.setTextColor(Color.RED);
  	textView5.setTypeface(null, Typeface.BOLD);
  	textView5.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView5);
   tableLayout.addView(tableRow);
     for (Integer j = 0; j < count; j++)
     {
         tableRow = new TableRow(getApplicationContext());
         textView1 = new TextView(getApplicationContext());
         textView1.setText(c.getString(c.getColumnIndex("fname")));
         textView2 = new TextView(getApplicationContext());
         textView2.setText(c.getString(c.getColumnIndex("lname")));
         textView3 = new TextView(getApplicationContext());
         textView3.setText(c.getString(c.getColumnIndex("email")));
         textView1.setPadding(20, 20, 20, 20);
         textView2.setPadding(20, 20, 20, 20);
         textView3.setPadding(20, 20, 20, 20);
         tableRow.addView(textView1);
         tableRow.addView(textView2);
         tableRow.addView(textView3);
         tableLayout.addView(tableRow);
         c.moveToNext() ;
     }
     setContentView(tableLayout);
db.close();
}
public void close(View view)
{
System.exit(0);	
}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
