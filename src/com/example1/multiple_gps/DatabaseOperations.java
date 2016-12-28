package com.example1.multiple_gps;

import com.example1.multiple_gps.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 1;
	public String CREATE_QUERY ="CREATE TABLE " +TableInfo.TABLE_NAME + "("+TableInfo.USER_NAME+" String primary key,"+TableInfo.USER_PASS+" String not null );";

	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Table created");
		
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		
		sdb.execSQL(CREATE_QUERY);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void putInformaion(DatabaseOperations dop, String name, String pass)
	{
	SQLiteDatabase SQ = dop.getWritableDatabase();
	ContentValues cv = new ContentValues();
	cv.put(TableInfo.USER_NAME, name);
	cv.put(TableInfo.USER_PASS, pass);
	long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
	Log.d("Database operations", "One row inserted");
	}
	

}
