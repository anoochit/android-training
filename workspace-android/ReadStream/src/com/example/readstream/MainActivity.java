package com.example.readstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button bntReadStream = (Button) findViewById(R.id.button1);
        
        bntReadStream.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ReadStream readStreamTask = new ReadStream();
				readStreamTask.execute(new String[] {"http://google.com"});
			}
		});
    
    }
    
    
    private class ReadStream extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			
			StringBuilder str = new StringBuilder();
			
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(params[0]);
			
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				
				int statusCode = statusLine.getStatusCode();
				
				if (statusCode==200) {
					Log.d("Log","200 Ok");
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					String line;
					while ((line = reader.readLine())!=null) {
						str.append(line);
					}					
				} else {
					Log.e("Log","Faild to download result");
				}				
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return str.toString();
		}

		@Override
		protected void onPostExecute(String result) { 
			Log.d("Log",result);
		}
    	
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}






