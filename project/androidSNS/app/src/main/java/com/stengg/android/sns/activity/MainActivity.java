package com.stengg.android.sns.activity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.stengg.android.sns.R;
import com.stengg.android.sns.config.SnsSettings;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class MainActivity extends TabActivity implements OnCheckedChangeListener {
	
	private static final String TAG = MainActivity.class.getName();
	private static final boolean DEBUG = SnsSettings.DEBUG;
	    
	private TabHost mHost;
	private Intent intent1;
	private Intent intent2;
	private Intent intent3;
	private Intent intent4;
	private Intent intent5;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_tabs); 
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.main_top_bar_view);
		
		intent1 = new Intent(this, HomeActivity.class);
		intent2 = new Intent(this, LooksActivity.class);
		intent3 = new Intent(this, CameraActivity.class);
		intent4 = new Intent(this, ShoppingActivity.class);
		intent5 = new Intent(this, ShowActivity.class);
		initRadio();
		setupIntent();
 
		initGUI();
	}

	private void initGUI() {
 
	}

	@Override
	public void onResume(){
		super.onResume();
		
		Bundle bundle = this.getIntent().getExtras();  
		String tab = null;
		if(bundle != null){
			tab = bundle.getString("tab"); 
		}
		if (DEBUG) {
			Log.d(TAG, "onResume bundle="+bundle+",tab="+tab);
		}
	}
	
	@Override  
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	    Log.i("test", "onActivityResult is working " + resultCode);  
	    if (resultCode == Activity.RESULT_OK) {  
			Bundle bundle = data.getExtras();  
			String tab = null;
			if(bundle != null){
				tab = bundle.getString("tab"); 
			}
			if (DEBUG) {
				Log.d(TAG, "onActivityResult bundle="+bundle+",tab="+tab);
			}
	    }  
	}  
	 

	private void setupIntent() {
		this.mHost = this.getTabHost();
	 
		this.mHost.addTab(buildTabSpec("tab0", "AAA", R.drawable.bottom_home, intent1));
		this.mHost.addTab(buildTabSpec("tab1", "BBB", R.drawable.bottom_looks, intent2));
		this.mHost.addTab(buildTabSpec("tab2", "CCC", R.drawable.bottom_camera, intent3));
		this.mHost.addTab(buildTabSpec("tab3", "DDD", R.drawable.bottom_shopping, intent4));
		this.mHost.addTab(buildTabSpec("tab4", "EEE", R.drawable.bottom_show, intent5));
		
		Bundle bundle = this.getIntent().getExtras();  
		String tab = null;
		if(bundle != null){
			tab = bundle.getString("tab"); 
		}
		if (DEBUG) {
			Log.d(TAG, "bundle="+bundle+",tab="+tab);
		}
		
		if(tab == null || tab.equalsIgnoreCase("tab0")){
			this.mHost.setCurrentTabByTag("tab0");
			setOnCheckedChangedDrawable(R.id.radio_btn_0,R.drawable.bottom_home_d);
		}else if(tab.equalsIgnoreCase("tab1")){
			 this.mHost.setCurrentTabByTag("tab1");
             setOnCheckedChangedDrawable(R.id.radio_btn_1,R.drawable.bottom_looks_d);
		}else if(tab.equalsIgnoreCase("tab2")){
			 this.mHost.setCurrentTabByTag("tab2");
             setOnCheckedChangedDrawable(R.id.radio_btn_2,R.drawable.bottom_camera_d);
		}else if(tab.equalsIgnoreCase("tab3")){
			 this.mHost.setCurrentTabByTag("tab3");
             setOnCheckedChangedDrawable(R.id.radio_btn_3,R.drawable.bottom_shopping_d);
		}else if(tab.equalsIgnoreCase("tab4")){
			this.mHost.setCurrentTabByTag("tab4");
            setOnCheckedChangedDrawable(R.id.radio_btn_4,R.drawable.bottom_show_d);
		} 
		
	}

	private TabHost.TabSpec buildTabSpec(String tag, String resLabel,
			int resIcon, final Intent content) {
		return this.mHost.newTabSpec(tag)
				.setIndicator(resLabel, getResources().getDrawable(resIcon))
				.setContent(content);
	}

	private void initRadio() {
		
		Resources resources =  this.getResources();
		 
		RadioButton home = ((RadioButton) findViewById(R.id.radio_btn_0));
		home.setOnCheckedChangeListener( this);
		setBackGroundDrawable(home,R.drawable.bottom_home);
		
		
		RadioButton looks  = ((RadioButton) findViewById(R.id.radio_btn_1));
		looks.setOnCheckedChangeListener( this);
		looks.setBackgroundDrawable(resources.getDrawable(R.drawable.bottom_looks));
		setBackGroundDrawable(looks,R.drawable.bottom_looks);
		
		RadioButton camera  = ((RadioButton) findViewById(R.id.radio_btn_2));
		camera.setOnCheckedChangeListener( this);
		camera.setBackgroundDrawable(resources.getDrawable(R.drawable.bottom_camera));
		setBackGroundDrawable(camera,R.drawable.bottom_camera);
		
		RadioButton shopping  = ((RadioButton) findViewById(R.id.radio_btn_3));
		shopping.setOnCheckedChangeListener( this);
		shopping.setBackgroundDrawable(resources.getDrawable(R.drawable.bottom_shopping));
		setBackGroundDrawable(shopping,R.drawable.bottom_shopping);
		
		RadioButton show  = ((RadioButton) findViewById(R.id.radio_btn_4));
		System.out.println(shopping);
		System.out.println(show);
		show.setOnCheckedChangeListener(this);
		show.setBackgroundDrawable(resources.getDrawable(R.drawable.bottom_show));
		setBackGroundDrawable(show,R.drawable.bottom_show);
	 
	}

	public void setBackGroundDrawable(RadioButton btn, int id){
		 Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(
                 id)).getBitmap(); 
		Drawable[] array = new Drawable[1];
		array[0] = new BitmapDrawable(bitmap1);
		LayerDrawable la = new LayerDrawable(array);
		la.setLayerInset(0, 20, 20, 20, 20);
		btn.setBackgroundDrawable(la);
		
	}
	
	public void setOnCheckedChangedDrawable(int radioId, int id){
		  
         Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(
                 R.drawable.bottom_select_bg)).getBitmap();
         Bitmap bitmap2 = ((BitmapDrawable) getResources().getDrawable(
        		 id)).getBitmap();

         Drawable[] array = new Drawable[2];
         array[0] = new BitmapDrawable(bitmap1);
         array[1] = new BitmapDrawable(bitmap2);
         LayerDrawable la = new LayerDrawable(array);
         // 其中第一个参数为层的索引号，后面的四个参数分别为left、top、right和bottom
         la.setLayerInset(0, 0, 0, 0, 0);
         la.setLayerInset(1, 20, 20, 20, 20);
         ((RadioButton) findViewById(radioId)).setBackgroundDrawable(la);
		
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			initRadio();
			
            switch (buttonView.getId()) {
            case R.id.radio_btn_0:
                this.mHost.setCurrentTabByTag("tab0");
                
                setOnCheckedChangedDrawable(R.id.radio_btn_0,R.drawable.bottom_home_d);
                break;
            case R.id.radio_btn_1:
                this.mHost.setCurrentTabByTag("tab1");
                setOnCheckedChangedDrawable(R.id.radio_btn_1,R.drawable.bottom_looks_d);
                break;
            case R.id.radio_btn_2:
                this.mHost.setCurrentTabByTag("tab2");
                setOnCheckedChangedDrawable(R.id.radio_btn_2,R.drawable.bottom_camera_d);
                break;
            case R.id.radio_btn_3:
                this.mHost.setCurrentTabByTag("tab3");
                setOnCheckedChangedDrawable(R.id.radio_btn_3,R.drawable.bottom_shopping_d);
                break;
            case R.id.radio_btn_4:
                this.mHost.setCurrentTabByTag("tab4");
                setOnCheckedChangedDrawable(R.id.radio_btn_4,R.drawable.bottom_show_d);
                break;
            }
        }
		
	}
	


}
