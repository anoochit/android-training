package com.example.customlistview;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FlagAdapter extends BaseAdapter {

	Context context;
	ArrayList<Flags> flags;
	
	LayoutInflater inflater;
	
	public FlagAdapter(ArrayList<Flags> flags, Context context) {
		this.flags=flags;
		this.context=context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() { 
		return flags.size();
	}

	@Override
	public Object getItem(int position) { 
		return flags.get(position);
	}

	@Override
	public long getItemId(int position) { 
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView==null) {
			convertView = inflater.inflate(R.layout.listview_item, null);
			holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.imageView1);
			holder.title = (TextView) convertView.findViewById(R.id.textView1);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.icon.setImageDrawable(flags.get(position).getFlagIcon());
		holder.title.setText(flags.get(position).getFlagTitle());
		
		return convertView;
	}
	
	class ViewHolder {
		ImageView icon;
		TextView title;
	}

}
