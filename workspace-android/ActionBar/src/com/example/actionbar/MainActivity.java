package com.example.actionbar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar actionbar = getActionBar();
		actionbar.setTitle("Hello App");
		actionbar.setSubtitle("Good greeting to the world");
		actionbar.setHomeButtonEnabled(true);
		
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case android.R.id.home:
				Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_about:
			Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_settings:
			Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_SHORT).show();
			break;

		}

		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
