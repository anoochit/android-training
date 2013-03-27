package com.example.notificationmanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bntShow = (Button) findViewById(R.id.button1);

		bntShow.setOnClickListener(new OnClickListener() {
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				Notification notification = new Notification.Builder(getApplicationContext())
						.setContentTitle("Title")
						.setContentText(
								"Hello World, This is notofocation text")
						.setSmallIcon(R.drawable.ic_launcher).build();
				NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				notification.flags |= Notification.FLAG_AUTO_CANCEL;
				notificationManager.notify(0,notification);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
