package com.stengg.android.sns.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stengg.android.sns.R;
import com.stengg.android.sns.config.SnsSettings;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class HomeActivity  extends Activity {

    private static final String TAG = HomeActivity.class.getName();
    private static final boolean DEBUG = SnsSettings.DEBUG;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_view); 
		initGUI(); 
	}
 
	private void initGUI() {
 
		TextView tvDateShow = (TextView)findViewById(R.id.tv_date_show);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月d日 EEE");
		String nowDate = sdf.format(new Date());
		tvDateShow.setText(nowDate);
		
		ImageView ivSettingBtn = (ImageView)findViewById(R.id.iv_setting_btn);
		ivSettingBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, SettingActivity.class);
        		HomeActivity.this.startActivity(intent); 
			}
			
		});
		
		ImageView ivRegisterBtn = (ImageView)findViewById(R.id.iv_register_btn);
		ivRegisterBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, RegisterActivity.class);
        		HomeActivity.this.startActivity(intent); 
			}
			
		});
		 
		ImageView ivLoginBtn = (ImageView)findViewById(R.id.iv_login_btn);
		ivLoginBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, LoginActivity.class);
        		HomeActivity.this.startActivity(intent); 
			}
			
		});
		
		LinearLayout llHomeIndexBtn = (LinearLayout)findViewById(R.id.home_index_btn);
		llHomeIndexBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				 
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, MainActivity.class);
        		Bundle bundle = new Bundle();  
        		bundle.putString("tab", "tab1");  
        		intent.putExtras(bundle);   
        		HomeActivity.this.startActivity(intent); 
        		finish();  
			}
		});
 
		LinearLayout llShoppingLayoutBtn = (LinearLayout)findViewById(R.id.shopping_index_layout_btn);
		llShoppingLayoutBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				 
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, MainActivity.class);
        		Bundle bundle = new Bundle();  
        		bundle.putString("tab", "tab3");  
        		intent.putExtras(bundle);   
        		HomeActivity.this.startActivity(intent); 
        		finish();  
			}
		});
		
		LinearLayout llShowLayoutBtn = (LinearLayout)findViewById(R.id.show_index_layout_btn);
		llShowLayoutBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, MainActivity.class);
        		Bundle bundle = new Bundle();  
        		bundle.putString("tab", "tab4");  
        		intent.putExtras(bundle);   
        		HomeActivity.this.startActivity(intent); 
        		finish();  
			}
		});
		
		LinearLayout llSearchLayoutBtn = (LinearLayout)findViewById(R.id.search_index_layout_btn);
		llSearchLayoutBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, SearchActivity.class);
        	 
        		HomeActivity.this.startActivity(intent); 
        		finish();  
			}
		});
		
		LinearLayout llBrowseLayoutBtn = (LinearLayout)findViewById(R.id.browse_index_layout_btn);
		llBrowseLayoutBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
        		intent.setClass(HomeActivity.this, BrowseActivity.class);
        	 
        		HomeActivity.this.startActivity(intent); 
        		finish();  
			}
		});
 
	}
 
}
