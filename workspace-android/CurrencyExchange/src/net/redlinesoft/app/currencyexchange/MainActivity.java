package net.redlinesoft.app.currencyexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	CurrencyItem currencyItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView) findViewById(R.id.listCurrency);
		listView.setAdapter(new CurrencyAdapter(getCurrencyData(), this));
	}

	public ArrayList<CurrencyItem> getCurrencyData() {

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

		ArrayList<CurrencyItem> currencyList = new ArrayList<CurrencyItem>();

		for (int i = 0; i < 13; i++) {

			currencyItem = new CurrencyItem();
			currencyItem.setIcon(getResources().getDrawable(curIcon[i]));
			currencyItem.setTitle_long(curTitle[i]);
			currencyItem.setTitle_short(curSign[i]);
			currencyList.add(currencyItem);

		}

		return currencyList;
	}

	String API_KEY = "0b8ffb5684a9b3a8c45e49b65cdc6c56681053f1";
	String URL_BEGIN = "http://currency-api.appspot.com/api/";
	String URL_END = "/THB.json?key=" + API_KEY;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
