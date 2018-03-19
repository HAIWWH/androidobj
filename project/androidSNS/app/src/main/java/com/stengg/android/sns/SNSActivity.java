package com.stengg.android.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.stengg.android.sns.activity.MainActivity;
import com.stengg.android.sns.thread.WelcomeThread;
/*
 * Powered By [178zhe.com]
 * Web Site: http://www.178zhe.com 
 * Since 2010 - 2011
 */

public class SNSActivity extends Activity {
	Animation myAnimation;//动画的引用
	ImageView myImageView;//ImageView的引用
 
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sns_view);
		
//		myAnimation= AnimationUtils.loadAnimation(this,R.anim.welcome);//加载动画
//        myImageView = (ImageView) this.findViewById(R.id.myImageView);//得到ImageView的引用
//        myImageView.startAnimation(myAnimation);//启动动画
        
        WelcomeThread thread = new WelcomeThread(){
        	@Override
        	public void run(){
        		try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		Intent intent = new Intent();
        		intent.setClass(SNSActivity.this, MainActivity.class);
        		SNSActivity.this.startActivity(intent);
        	}
        }; 
        
        new Thread(thread).start();
	}
	
	
}