package net.redlinesoft.app.currencyexchange;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        ListView listView = (ListView) findViewById(R.id.listCurrency);        
        listView.setAdapter( new CurrencyAdapter(getCurrencyData(),this));        
    }
    
    public  ArrayList<CurrencyItem> getCurrencyData() {
    	ArrayList<CurrencyItem> currencyList = new ArrayList<CurrencyItem>();
    	    	
    	return currencyList;    	
    }
    
    private float getRate(String code) {
    	
		return 0;    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
