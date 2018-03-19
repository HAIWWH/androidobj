package com.stengg.android.sns.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stengg.android.sns.R;
import com.stengg.android.sns.activity.model.HomeListModel;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class PersonAdapter extends ArrayAdapter<HomeListModel>{

	LayoutInflater mLayoutInflater;
    int resourceId;
    Context mContext;
    
	public PersonAdapter(Context context, int resourceId, HomeListModel[] objects) {
		super(context, resourceId, objects);
 
        this.resourceId = resourceId;
        mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
            convertView = mLayoutInflater.inflate(resourceId, null);
        }
		
		HomeListModel person = getItem(position);
 
        ImageView img  = (ImageView)convertView.findViewById(R.id.img);
        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView info = (TextView)convertView.findViewById(R.id.info);
 
		img.setBackgroundResource(person.getImg());
        title.setText(person.getTitle());
        info.setText(person.getInfo());

        return convertView;
	}
	
	

	

}
