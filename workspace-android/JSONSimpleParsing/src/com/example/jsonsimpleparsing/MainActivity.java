package com.example.jsonsimpleparsing;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// json string
		String json = "{ \"firstname\":\"Anuchit\", \"lastname\":\"Chalothorn\" }";

		try {
			JSONObject c = new JSONObject(json);
			String firstName = c.getString("firstname");
			String lastName = c.getString("lastname");

			// mapping push data to text view
			TextView txtName = (TextView) findViewById(R.id.textView2);
			txtName.setText(new StringBuilder().append(firstName).append(" ")
					.append(lastName));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
