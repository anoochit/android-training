package net.redlinesoft.app.currencyexchange;

import java.text.NumberFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyAdapter extends BaseAdapter {
	
	Context context;
	ArrayList<CurrencyItem> item;
	LayoutInflater inflater;
	ViewHolder holder;

	public CurrencyAdapter(ArrayList<CurrencyItem> item, Context context) {
		// TODO Auto-generated constructor stub
		this.item=item;
		this.context=context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return item.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView==null) {			
			convertView = inflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.iconCurency);
			holder.title_long = (TextView) convertView.findViewById(R.id.textTitleLong);
			holder.title_short = (TextView) convertView.findViewById(R.id.textTitleShort);
			holder.rate = (TextView) convertView.findViewById(R.id.textRate);			
			convertView.setTag(holder);			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.icon.setImageDrawable(item.get(position).getIcon());
		holder.title_long.setText(item.get(position).getTitle_long());
		holder.title_short.setText(item.get(position).getTitle_short());
		
		String strAmount = NumberFormat.getInstance().format(item.get(position).getRate());
		
		if (strAmount.equals("0")) {
			holder.rate.setText("n/a");
		} else {
			holder.rate.setText(strAmount);	
		}
		
		return convertView;
	}	
	
	class ViewHolder {
		ImageView icon;
		TextView title_long;
		TextView title_short;
		TextView rate;
	}
	
	
}
