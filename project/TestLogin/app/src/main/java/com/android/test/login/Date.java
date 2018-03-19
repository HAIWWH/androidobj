package com.android.test.login;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Date extends ListActivity{
	private ListViewAdapter adapter;
	private ImageButton imageButton;
	private EditText account;
	private EditText password;
	private TextView textView =null;
	ArrayList<String> items;
	int flag;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);
		account = (EditText) findViewById(R.id.login_edit_account);
		password = (EditText) findViewById(R.id.login_edit_pwd);
		if(textView!=null){
		textView.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				Toast.makeText(Date.this, flag+"", Toast.LENGTH_SHORT).show();

			}
		});
		}
		account.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getListView().setVisibility(View.GONE);
			}
		});
		imageButton = (ImageButton) findViewById(R.id.ImageButton02);
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vgShow();
			}
		});
		items = new ArrayList<String>();
		if(items.size()==0){
		for (int i = 11454521; i < 11454526; i++) {
			items.add(String.valueOf(i + 1));
		}
		}
		adapter = new ListViewAdapter(this, items);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		flag = position;
		getListView().setVisibility(View.GONE);
		account.setText(items.get(position)+"");
		password.setText(items.get(position)+"");
		super.onListItemClick(l, v, position, id);
	}
	
	private void vgShow(){
		if (getListView().getVisibility() == View.GONE) {
			getListView().setVisibility(View.VISIBLE);
			getListView().setDivider(null);
			getListView().setDividerHeight(0);
		} else {
			getListView().setVisibility(View.GONE);
		}
	}
	
	class ListViewAdapter extends BaseAdapter {
		private List<String> items;
		private LayoutInflater inflater;

		public ListViewAdapter(Context context, List<String> items) {
			this.items = items;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return items.size();
		}

		@Override
		public Object getItem(int position) {
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			if (view == null) {
				view = inflater.inflate(R.layout.list_item, null);
			}
			TextView text = (TextView) view.findViewById(R.id.list_item_text);
			textView = (TextView)view.findViewById(R.id.deltxt);
			text.setText(items.get(position));
			return view;
		}
	}

}