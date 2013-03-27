package net.redlinesoft.app.timepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	Context context=this;
	TextView txtTime;
	
	static final int DIALOG_TIMEPICKER=0;
	int mMinut,mHour;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// mapping
		Button bntTimePicker = (Button) findViewById(R.id.button1);		
		txtTime= (TextView) findViewById(R.id.textView1);
		
		bntTimePicker.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				showDialog(DIALOG_TIMEPICKER);
			}
		});
		
		final Calendar c = Calendar.getInstance();
		mHour=c.get(Calendar.HOUR_OF_DAY);
		mMinut=c.get(Calendar.MINUTE);
		
		updateDisplay();
		
	}
	
	private void updateDisplay() {
		// TODO Auto-generated method stub
		txtTime.setText(new StringBuilder().append(mHour).append(":").append(mMinut));
	}

	private TimePickerDialog.OnTimeSetListener mTimePicker = new TimePickerDialog.OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mHour=hourOfDay;
			mMinut=minute;
			
			updateDisplay();
			
		}
	};
	
	

	@Override
	protected Dialog onCreateDialog(int id) {
		
		switch(id) {
		case DIALOG_TIMEPICKER : return new TimePickerDialog(context, mTimePicker, mHour, mMinut, true);
		}
		
		return null;		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
