package net.redlinesoft.app.currencyexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	CurrencyItem currencyItem;
	ListView listView;
	Context context;	
	ArrayList<CurrencyItem> currencyList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		context = this;
		listView = (ListView) findViewById(R.id.listCurrency);		
		new GetCurrency().execute(new String[] {null});
	}

	class GetCurrency extends AsyncTask<String, Void, ArrayList> {
		
		ProgressDialog dialog;
				
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(context);
			dialog.setMessage(getResources().getString(R.string.txt_loading));
			dialog.setIndeterminate(true);
			dialog.setCancelable(false);
			dialog.show();
		}
		
		@Override
		protected void onPostExecute(ArrayList result) {
			super.onPostExecute(result);
			listView.setAdapter(new CurrencyAdapter(result, context));
			dialog.dismiss();
		}

		public Double getCurrency(String code) {
			Double result = 0.0;
			
			String API_KEY = "0b8ffb5684a9b3a8c45e49b65cdc6c56681053f1";
			String URL_BEGIN = "http://currency-api.appspot.com/api/";
			String URL_END = "/THB.json?key=" + API_KEY;
			
			StringBuilder str = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(URL_BEGIN+code+URL_END); 

			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) { // Status OK
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					String line;
					while ((line = reader.readLine()) != null) {
						str.append(line);
					}
					try {
						JSONObject jsonObject = new JSONObject(str.toString());
						result = jsonObject.getDouble("amount");
						Log.d("LOG", result.toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Log.e("Log", e.getMessage());
					}
				} else {
					Log.e("Log", "Failed to download result..");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				Log.e("Log", e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				Log.e("Log", e.getMessage());
			}
			return result;
		}

		@Override
		protected ArrayList doInBackground(String... params) {

			int[] curIcon = { R.drawable.ic_australia, R.drawable.ic_canada,
					R.drawable.ic_switzerland, R.drawable.ic_denmark,
					R.drawable.ic_euro, R.drawable.ic_england,
					R.drawable.ic_hongkong, R.drawable.ic_japan,
					R.drawable.ic_maxico, R.drawable.ic_newzealand,
					R.drawable.ic_philippine, R.drawable.ic_sweden,
					R.drawable.ic_singapore, R.drawable.ic_usa,
					R.drawable.ic_southafrican };
			String[] curTitle = getResources().getStringArray(R.array.cur_string);
			String[] curSign = getResources().getStringArray(R.array.sgn_string);
			
			currencyList = new ArrayList<CurrencyItem>();
			
			for (int i = 0; i < curIcon.length; i++) {
				currencyItem = new CurrencyItem();
				currencyItem.setIcon(getResources().getDrawable(curIcon[i]));
				currencyItem.setTitle_long(curTitle[i].toString());
				currencyItem.setTitle_short(curSign[i].toString());
				currencyItem.setRate(this.getCurrency(curSign[i].toString()));
				currencyList.add(currencyItem);
			}
			
			return currencyList;
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case R.id.action_refresh:
        	new GetCurrency().execute(new String[] {null});
            return true;        
        default:
            return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
