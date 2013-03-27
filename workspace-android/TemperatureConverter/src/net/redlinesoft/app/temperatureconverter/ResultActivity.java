package net.redlinesoft.app.temperatureconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		// get value from first activity
		Bundle result = getIntent().getExtras();
		String txtResultValue = result.getString("RESULT");
		
		// mapping
		TextView txtResult = (TextView) findViewById(R.id.textView2);
		txtResult.setText(txtResultValue);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
