package com.example.sqliteexternalstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION=1;
	

	public DatabaseHelper(Context context) {
		super(context, context.getExternalFilesDir(null).getAbsolutePath().toString() + "/mydatabase.db", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE member (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT(100), tel TEXT(20));");
		Log.d("DB","Create table complete");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
