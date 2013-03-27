package net.redlinesoft.app.datepickerdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txtDate;
	int mYear,mMonth,mDate;
	static final int DATEPICKER_DIALOG=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		Button bntShowDialog = (Button) findViewById(R.id.button1);
		txtDate = (TextView) findViewById(R.id.textView1);
		
		//event
		bntShowDialog.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATEPICKER_DIALOG);
			}
		});		
		
		final Calendar c = Calendar.getInstance();
		mDate=c.get(Calendar.DAY_OF_MONTH);
		mMonth=c.get(Calendar.MONTH);
		mYear=c.get(Calendar.YEAR);
		
		updateDisplay();
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		
		switch(id) {
		case DATEPICKER_DIALOG : return new DatePickerDialog(this,mDatePicker,mYear,mMonth,mDate);		
		}
		
		return null;
	}

	private DatePickerDialog.OnDateSetListener mDatePicker = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			mDate=dayOfMonth;
			mMonth=monthOfYear;
			mYear=year;
			
			// update text view
			updateDisplay();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void updateDisplay() {
		// TODO Auto-generated method stub
		txtDate.setText(new StringBuffer().append(mDate).append("-").append(mMonth).append("-").append(mYear));
	}
 

}
