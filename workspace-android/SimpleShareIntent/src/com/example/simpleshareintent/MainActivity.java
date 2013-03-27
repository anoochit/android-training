package com.example.simpleshareintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		final EditText txtShare = (EditText) findViewById(R.id.editText1);
		Button bntShare = (Button) findViewById(R.id.button1);
		
		// event
		bntShare.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// get some text
				String shareText = txtShare.getText().toString().trim();								
				// intent
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, shareText);
				startActivity(intent);
				
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
