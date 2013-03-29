package com.example.getstoragepath;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// read internal storage path
		File internal_path=getDir(Environment.DIRECTORY_DOWNLOADS, 0);		
		File external_path= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		
		TextView txtInternalPath=(TextView) findViewById(R.id.textView2);
		TextView txtExternalPath=(TextView) findViewById(R.id.textView4);
		
		txtInternalPath.setText(internal_path.toString());
		txtExternalPath.setText(external_path.toString());
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
