package com.example.simplecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, context.getExternalFilesDir(null).getAbsolutePath()
				.toString()
				+ "/crud.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE member (id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT(100)," + "tel TEXT(20)); ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public long InsertData(String name, String tel) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues val = new ContentValues();
			val.put("name", name);
			val.put("tel", tel);
			long row = db.insert("member", null, val);
			db.close();
			Log.d("DB", "insert complete");
			return row;
		} catch (Exception e) {
			Log.d("DB", "insert fail");
			return -1;
		}
	}

	public String[] SelectData(String id) {

		try {

			SQLiteDatabase db;
			db = this.getWritableDatabase();
			Cursor cursor = db.query("member", new String[] { "*" }, "id=?",
					new String[] { String.valueOf(id) }, null, null, null);
			String[] arrData = null;
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					arrData = new String[cursor.getColumnCount()];
					arrData[0] = cursor.getString(0);
					arrData[1] = cursor.getString(1);
					arrData[2] = cursor.getString(2);
				}
			}
			cursor.close();
			db.close();
			Log.d("DB", "Select complete");
			return arrData;
		} catch (Exception e) {
			Log.d("DB", "Select fail");
			return null;
		}
	}
	
	public String[][] SelectAllData() {
		
		try {
			String arrData[][]=null;
			SQLiteDatabase db;
			db= this.getReadableDatabase();
			
			String strSQL="SELECT * FROM member";
			Cursor cursor = db.rawQuery(strSQL, null);
			
			if (cursor!=null) {
				if (cursor.moveToFirst()) {
					arrData = new String[cursor.getCount()][cursor.getColumnCount()];
					int i = 0;
					do {
						arrData[i][0] = cursor.getString(0);
						arrData[i][1] = cursor.getString(1);
						arrData[i][2] = cursor.getString(2);
						i++;
					} while (cursor.moveToNext());
				}
			}
			cursor.close();
			db.close();
			return arrData;
			
		} catch(Exception e) {
			Log.d("DB","select all fail");
			return null;
		}
		
	}
	
	public long UpdateData(String id,String name,String tel) {
		try{
			SQLiteDatabase db;
			db = this.getWritableDatabase();			
			ContentValues val = new ContentValues();
			val.put("name", name);
			val.put("tel", tel);
			long row = db.update("member", val, "id=?", new String[] {String.valueOf(id)});
			db.close();
			return row;			
		}catch (Exception e) {
			Log.d("DB","update failed");
			return -1;
		}
	}
	
	public long DeteteData(String id){		
		try{
			SQLiteDatabase db;
			db= this.getWritableDatabase();
			long row = db.delete("member","id=?", new String[] {String.valueOf(id)});
			db.close();
			return row;			
		} catch(Exception e) {
			Log.d("DB","delete failed");
			return -1;		
		}
	}
	
	
	
}
