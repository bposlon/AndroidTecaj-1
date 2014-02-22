package com.example.test.activities;

import com.example.test.R;
import com.example.test.utils.C;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends BaseActivity{
	private TextView mImeTextView;
	private TextView mPrezimeTextView;
	private TextView mAdresaTextView;
	private String tempIme;
	private String tempPrezime;
	private String tempAdresa;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initUi();
		
		Bundle extras = getIntent().getExtras();
		if (extras !=null){
			initExtras(extras);
		}
		setTitletextView();
	}
	@Override
	public void initUi(){
		mImeTextView = (TextView) findViewById(R.id.activity_second_ime_textview);
		mPrezimeTextView = (TextView) findViewById(R.id.activity_second_prezime_textview);
		mAdresaTextView = (TextView) findViewById(R.id.activity_second_adresa_textview);
	}
	private void initExtras(Bundle extras){
		tempIme = extras.getString(C.MAIN_ACTIVITY_BUNDLE_KEY_IME);
		tempPrezime = extras.getString(C.MAIN_ACTIVITY_BUNDLE_KEY_PREZIME);
		tempAdresa = extras.getString(C.MAIN_ACTIVITY_BUNDLE_KEY_ADRESA);
	}
	private void setTitletextView(){
		mImeTextView.setText(tempIme);
		mPrezimeTextView.setText(tempPrezime);
		mAdresaTextView.setText(tempAdresa);	}
	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
