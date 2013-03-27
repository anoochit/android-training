package com.example.jsonarrayparsing;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// json string

		String json = "[ { \"firstname\": \"Anuchit\", \"lastname\":\"Chalothorn\" },"
				+ "{ \"firstname\": \"Sira\", \"lastname\":\"Nokyongthong\" },"
				+ "{ \"firstname\": \"Pakpoom\", \"lastname\":\"Iamjitkusol\" },"
				+ "{ \"firstname\": \"Virat\", \"lastname\":\"Pungsara\" } ]";

		try {
			JSONArray data = new JSONArray(json);

			ArrayList<HashMap<String, String>> mArrayList = new ArrayList<HashMap<String, String>>();

			HashMap<String, String> map;

			// parse data to arraylist
			for (int i = 0; i < data.length(); i++) {
				JSONObject c = data.getJSONObject(i);

				map = new HashMap<String, String>();
				map.put("firstname", c.getString("firstname"));
				map.put("lastname", c.getString("lastname"));

				mArrayList.add(map);

			}

			SimpleAdapter adapter = new SimpleAdapter(this, mArrayList,
					R.layout.list_row,
					new String[] { "firstname", "lastname" }, new int[] {
							R.id.textFirstName, R.id.textLastName });
			
			ListView listView = (ListView) findViewById(R.id.listView1);
			listView.setAdapter(adapter);
			
			

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
