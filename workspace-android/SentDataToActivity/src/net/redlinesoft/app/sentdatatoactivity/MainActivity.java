package net.redlinesoft.app.sentdatatoactivity;

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
		final EditText txtText = (EditText) findViewById(R.id.editText1);
		Button bntSent = (Button) findViewById(R.id.button1);
		
		// set on click
		bntSent.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// get text from edit text
				String value = txtText.getText().toString().trim();
				// sent data
				Intent i = new Intent(getApplicationContext(),SecondActivity.class);
				i.putExtra("VALUE", value);
				startActivity(i);
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
