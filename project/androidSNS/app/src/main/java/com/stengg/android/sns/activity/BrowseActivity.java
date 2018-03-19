package com.stengg.android.sns.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.stengg.android.sns.R;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class BrowseActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browse_view);
		initGUI();
	}

	private void initGUI() {
		TextView tvBackBtn = (TextView) findViewById(R.id.tv_back_btn);
		tvBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(BrowseActivity.this, MainActivity.class);
				BrowseActivity.this.startActivity(intent);
			}
		});
	}
}
