package net.redlinesoft.app.checknetworkconnection;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button bntCheckConnection = (Button) findViewById(R.id.button1);
        
        bntCheckConnection.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isOnline()==true) {
					Toast.makeText(getApplicationContext(), "Online", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Offline", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private boolean isOnline() {
    	Boolean result=false;
    	
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	
    	if (networkInfo != null && networkInfo.isConnected()) {
    		result=true;
    	} else {
    		result=false;
    	}
    	
    	return result;
    }
    
}











