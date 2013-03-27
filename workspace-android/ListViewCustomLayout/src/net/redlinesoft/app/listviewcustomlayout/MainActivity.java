package net.redlinesoft.app.listviewcustomlayout;

import java.util.ArrayList;
import java.util.HashMap;

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

		// mapping
		ListView listView = (ListView) findViewById(R.id.listView1);

		// array list
		ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();

		HashMap map;

		map = new HashMap<String, String>();
		map.put("ID", "1");
		map.put("NAME", "Anuchit Chalothorn");
		arraylist.add(map);

		map = new HashMap<String, String>();
		map.put("ID", "2");
		map.put("NAME", "Sira Nokyoungthong");
		arraylist.add(map);

		map = new HashMap<String, String>();
		map.put("ID", "3");
		map.put("NAME", "Jira Sombutthip");
		arraylist.add(map);

		SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
				arraylist, R.layout.row_listview, new String[] {"NAME"}, new int[] {R.id.textView1});
		
		listView.setAdapter(adapter);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
