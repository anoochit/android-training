package com.example.sharepreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText txtSharePreference = (EditText) findViewById(R.id.editText1);
		Button bntSave = (Button) findViewById(R.id.button1);
		Button bntShow = (Button) findViewById(R.id.button2);
		
		final SharedPreferences sharePrf = getSharedPreferences("preference",0);
		
		// save button
		bntSave.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				String value= txtSharePreference.getText().toString().trim();
				Editor edit = sharePrf.edit();
				edit.putString("name", value);
				edit.commit();
			}
		});
		
		// show button
		bntShow.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				String value = sharePrf.getString("name", "n/a");
				Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
