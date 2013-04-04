package net.redlinesoft.app.sweetwords;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import net.redlinesoft.app.sweetwords.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArrayList<HashMap<String,String>> wordList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// check database exist
		try {
			String destPath = getExternalFilesDir(null).getAbsolutePath().toString() + "/word.db";
			
			File f = new File(destPath);
			if (!f.exists()) {
				Log.d("DB","Database not exist, copy from asset");
				InputStream in = getAssets().open("word.db");
				OutputStream out = new FileOutputStream(destPath);
				
				byte[] buffer = new byte[1024];
				int length;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer,0,length);
				}
				
				in.close();
				out.close();				
			}
			
		} catch (Exception e) {
			Log.d("DB",e.getMessage());
		}
		
		// initial database helper
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		wordList = dbHelper.SelectAllData();
		
		// mapping
		ListView wordListView = (ListView) findViewById(R.id.listView1);
		
		final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/nithan.ttf");

		
		SimpleAdapter adapter = new SimpleAdapter(this, wordList, R.layout.list_column, new String[] {"text"}, new int[] {R.id.textView1}){

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View v = convertView;
	            if(v== null){
	                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                v=vi.inflate(R.layout.list_column, null);
	            }
	            TextView tv = (TextView)v.findViewById(R.id.textView1);
	            tv.setText(wordList.get(position).get("text"));
	            tv.setTypeface(font);
	            return v;
			}
			
		};
		
		wordListView.setAdapter(adapter);
		
		wordListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) { 
				String txtWord = wordList.get(position).get("text").toString();
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, txtWord);
				startActivity(intent);
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
