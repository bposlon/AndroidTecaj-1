package com.thed.weather.activities;

import com.thed.weather.R;
import com.thed.weather.utils.HandleXML;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends BaseActivity {

	private TextView mdatetime,ms1,ms2,ms3,ms4;
	private HandleXML mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUi();

		open();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Refresh:
			Toast.makeText(getBaseContext(), "...Refreshing...", Toast.LENGTH_LONG).show();
			open();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void open(){

		mHandler = new HandleXML("http://arduino-dkurtagic.rhcloud.com/sensor.xml");
		mHandler.fetchXML();
		while(mHandler.parsingComplete);
		mdatetime.setText(mHandler.getDatetime());
		ms1.setText(mHandler.getS1());
		ms2.setText(mHandler.getS2());
		ms3.setText(mHandler.getS3());
		ms4.setText(mHandler.getS4());


	}


	@Override
	public void initUi() {
		mdatetime = (TextView)findViewById(R.id.activity_main_datetime_textview);
		ms1 = (TextView)findViewById(R.id.activity_main_s1_textview);
		ms2 = (TextView)findViewById(R.id.activity_main_s2_textview);
		ms3 = (TextView)findViewById(R.id.activity_main_s3_textview);
		ms4 = (TextView)findViewById(R.id.activity_main_s4_textview);

	}

	@Override
	public void initListeners(){

	}
}