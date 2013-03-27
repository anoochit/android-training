package com.example.listviewstringarray;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		ListView listView = (ListView) findViewById(R.id.listView1);		
		ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,R.array.services, android.R.layout.simple_list_item_1);		
		listView.setAdapter(mAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
