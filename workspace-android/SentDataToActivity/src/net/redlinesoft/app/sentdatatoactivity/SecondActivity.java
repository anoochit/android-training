package net.redlinesoft.app.sentdatatoactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		// mapping
		TextView txtText = (TextView) findViewById(R.id.textView1);
		
		// get data from first activity
		Bundle extras = getIntent().getExtras();
		if (extras!=null) {
			// get value
			String txtValue = extras.getString("VALUE");
			txtText.setText(txtValue);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
