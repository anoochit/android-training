package net.redlinesoft.app.dialogcustomlayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		Button bntShowDialog = (Button) findViewById(R.id.button1);
		
		bntShowDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Dialog dialog = new Dialog(context);
				dialog.setTitle("Alert");				
				dialog.setContentView(R.layout.custom_dialog);
				dialog.show();
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
