package com.along.friendlyreminder;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
/**
 * ��תʸ��������
 * @author Windows
 *
 */
public class RotationActivity extends Activity implements SensorEventListener {

	private Button btn;

	private TextView tv_context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		infoViews();// ��ʼ���ؼ�

	}

	private void infoViews() {

		btn = (Button) findViewById(R.id.btn_sensor);
		tv_context = (TextView) findViewById(R.id.tv_context);
		tv_context.setText("��תʸ��������");
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
	}
	private Sensor mAccelerometer;

	private SensorManager mSensorManager;
	@Override
	protected void onResume() {

		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		super.onResume();
	}

	protected void onPause() {

		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
//		Log.d(TAG, accuracy + "--"+sensor.getMaximumRange());
	}

	public void onSensorChanged(SensorEvent event) {
		float[] values=event.values;
		tv_context.setText("X����תʸ����ֵ����"+values[0]+"\nY��תʸ����ֵ����"+values[1]+"\nZ����תʸ����ֵ����"+values[2]);
	}
}