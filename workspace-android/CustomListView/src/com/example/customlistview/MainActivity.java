package com.example.customlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView flagListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		flagListView = (ListView) findViewById(R.id.listView1);		
		flagListView.setAdapter(new FlagAdapter(getFlags(),this));
	}

	public ArrayList<Flags> getFlags() {
		ArrayList<Flags> flagsList = new ArrayList<Flags>();
		
		Flags flag = new Flags();
		flag.setFlagIcon(getResources().getDrawable(R.drawable.ic_japan));
		flag.setFlagTitle("Japan");
		flagsList.add(flag); 
		
		return flagsList;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
