package net.redlinesoft.app.spiner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		final Spinner spnService = (Spinner) findViewById(R.id.spinner1);
		Button bntSubmit = (Button) findViewById(R.id.button1);
		
		// push string array to spinner
		ArrayAdapter mAdapter = ArrayAdapter.createFromResource(this, R.array.servcies, android.R.layout.simple_spinner_dropdown_item);
		mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnService.setAdapter(mAdapter); 		
		
		bntSubmit.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) { 
				Toast.makeText(getApplicationContext(), spnService.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
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
