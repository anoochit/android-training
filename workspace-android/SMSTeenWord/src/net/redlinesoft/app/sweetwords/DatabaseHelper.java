package net.redlinesoft.app.sweetwords;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;

import org.apache.http.params.CoreConnectionPNames;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, context.getExternalFilesDir(null).getAbsolutePath().toString()+"/word.db", null, 1);		
	}
	
	public ArrayList<HashMap<String,String>> SelectAllData() {
		try {
			ArrayList<HashMap<String, String>> mArrayList = new ArrayList<HashMap<String,String>>();
			HashMap<String, String> map;
			
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			String strSQL = "SELECT * FROM word";
			Cursor cursor = db.rawQuery(strSQL, null);
			
			if (cursor!=null) {
				if (cursor.moveToFirst()) {
					do {
						map=new HashMap<String, String>();
						map.put("id", cursor.getString(0));
						map.put("text", cursor.getString(1));
						mArrayList.add(map);						
					} while(cursor.moveToNext());
				}
			}
			Log.d("DB","Select complete");
			cursor.close();
			db.close();
			return mArrayList;
			
		} catch (Exception e) {
			Log.d("DB","Select failed");
			return null;
		}
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
