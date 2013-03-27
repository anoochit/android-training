package net.redlinesoft.app.temperatureconverter;

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
		final EditText txtTemperature = (EditText) findViewById(R.id.editText1);
		Button bntConvertCelcius = (Button) findViewById(R.id.button1);
		Button bntConvertFahrenheit = (Button) findViewById(R.id.button2);
		
		// button on click
		bntConvertCelcius.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Double tempValue = Double.parseDouble(txtTemperature.getText().toString().trim());
				// convert to celcius
				Double tempResult;
				tempResult = ((tempValue - 32)*5)/9;
				Intent i = new Intent(getApplicationContext(),ResultActivity.class);
				i.putExtra("RESULT", String.valueOf(tempResult));
				startActivity(i);
			}
		});
		
		bntConvertFahrenheit.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) { 
				Double tempValue = Double.parseDouble(txtTemperature.getText().toString().trim());
				Double tempResult;
				// convert to fahrenheit
				tempResult = ((tempValue * 9)/5)+32;
				Intent i = new Intent(getApplicationContext(),ResultActivity.class);
				i.putExtra("RESULT", String.valueOf(tempResult));
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
