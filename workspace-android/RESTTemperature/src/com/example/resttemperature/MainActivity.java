package com.example.resttemperature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	static final String uri = "http://aru-redcloud.rhcloud.com/temperature/index.php";
	ArrayList<NameValuePair> params;
	TextView txtResult;
	String unitType = "c";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtResult = (TextView) findViewById(R.id.textView1);
		Button bntSubmit = (Button) findViewById(R.id.button1);
		final EditText txtDegree = (EditText) findViewById(R.id.editText1);

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				switch (arg1) {
				case R.id.radio0:
					unitType = "c";
					break;
				case R.id.radio1:
					unitType = "f";
					break;
				}
			}
		});

		bntSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// get text value
				String txtDegreeValue = txtDegree.getText().toString().trim();

				// sent to rest api
				params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("type", unitType));
				params.add(new BasicNameValuePair("degree", txtDegreeValue));

				ConvertTask convertTask = new ConvertTask();
				convertTask.execute(new String[] {});
			}
		});

	}

	private class ConvertTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPostExecute(String result) {
			// parse json string
			String strResult;
			try {
				JSONObject c = new JSONObject(result);
				strResult = c.getString("result");
				txtResult.setText(strResult);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected String doInBackground(String... arg0) {
			// sent data to rest api
			StringBuilder str = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(uri);

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				HttpResponse response = client.execute(httpPost);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(content));
					String line;
					while ((line = reader.readLine()) != null) {
						str.append(line);
					}
					// log for check return string
					Log.d("log", str.toString());
				} else {
					// log for error
					Log.e("log", "fail to connect");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return str.toString();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
