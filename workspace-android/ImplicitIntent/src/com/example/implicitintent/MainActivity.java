package com.example.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Spinner spService = (Spinner) findViewById(R.id.spinner1);
		Button bntSubmit = (Button) findViewById(R.id.button1);

		ArrayAdapter mAdapter = ArrayAdapter
				.createFromResource(this, R.array.services,
						android.R.layout.simple_spinner_dropdown_item);
		mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spService.setAdapter(mAdapter);

		bntSubmit.setOnClickListener(new OnClickListener() {
			Intent intent;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (spService.getSelectedItemPosition()) {
				case 0:
					intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("http://google.com"));
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(Intent.ACTION_DIAL, Uri
							.parse("tel:199"));
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(Intent.ACTION_CALL, Uri
							.parse("tel:0898433777"));
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("geo:0,0?q=13.888203,100.578712 (Laksri)"));
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("geo:0,0?q=SIPA+สำนักงานส่งเสริมอุตสาหกรรมซอฟต์แวร์แห่งชาติ"));
					startActivity(intent);
					break;
				}
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
