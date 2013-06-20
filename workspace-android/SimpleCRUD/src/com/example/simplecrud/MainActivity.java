package com.example.simplecrud;

import android.app.Activity;
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
        
        
        final DatabaseHelper myDBHelper = new DatabaseHelper(this);
        myDBHelper.getWritableDatabase();
        
        // insert button
        Button bntInsert = (Button) findViewById(R.id.button1);
        bntInsert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myDBHelper.InsertData("Jim", "023645456");
				myDBHelper.InsertData("John", "023645876");
			}
		});
        
        // select button
        Button bntSelect = (Button) findViewById(R.id.button2);
        bntSelect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String arrData[] = myDBHelper.SelectData("2");
				if (arrData==null) {
					Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Name = " + arrData[1] +" Tel = " + arrData[2], Toast.LENGTH_SHORT).show();
						
				}
			}
		});
        
        // select all button
        Button bntSelectAll = (Button) findViewById(R.id.button3);
        bntSelectAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String arrData[][] = myDBHelper.SelectAllData();
				if (arrData==null) {
					Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_SHORT).show();
				} else {
					for (int i=0;i<arrData.length;i++){
						Toast.makeText(getApplicationContext(), "Name = " + arrData[i][1] + " Tel = "+arrData[i][2], Toast.LENGTH_LONG).show();
					}		
				}
			}
		});
        
        // update button
        Button bntUpdate = (Button) findViewById(R.id.button4);
        bntUpdate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) { 
				long result = myDBHelper.UpdateData("1", "Jim", "023003560");
				if (result>0) {
					Toast.makeText(getApplicationContext(), "Update complete", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Update failed", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        // delete button
        Button bntDeleteData = (Button) findViewById(R.id.button5);
        bntDeleteData.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				long result=myDBHelper.DeteteData("2");
				if (result>0) {
					Toast.makeText(getApplicationContext(), "Delete Complete", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Delete failed", Toast.LENGTH_SHORT).show();						
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
    
}
