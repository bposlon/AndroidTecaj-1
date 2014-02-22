package com.example.test.activities;

import com.example.test.R;
import com.example.test.utils.C;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
	private EditText mInputImeEditText;
	private EditText mInputPrezimeEditText;
	private EditText mInputAdresaEditText;
	private Button mSubmitButton;
	private Button mDeleteButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUi();
		initListeners();
	}

	public void initUi(){
		mInputImeEditText = (EditText) findViewById(R.id.activity_main_ime_edittext);
		mInputPrezimeEditText = (EditText) findViewById(R.id.activity_main_prezime_edittext);
		mInputAdresaEditText = (EditText) findViewById(R.id.activity_main_adresa_edittext);
		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mDeleteButton = (Button) findViewById(R.id.activity_main_cancel_button);
	}
	public void initListeners(){
		mSubmitButton.setOnClickListener(mOnCickListener);
		mDeleteButton.setOnClickListener(mOnCickListener);
	}
	private OnClickListener mOnCickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()){
			case R.id.activity_main_cancel_button:
				mInputImeEditText.setText("");
				mInputPrezimeEditText.setText("");
				mInputAdresaEditText.setText("");
				break;
				
			case R.id.activity_main_submit_button:
				String tempIme = mInputImeEditText.getText().toString();
				String tempPrezime = mInputPrezimeEditText.getText().toString();
				String tempAdresa = mInputAdresaEditText.getText().toString();
				startSecondActivity (tempIme,tempPrezime,tempAdresa);
				break;
			}
			
		}
	};
	private void startSecondActivity(String predanoIme,String predanoPrezime, String predanaAdresa){
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_IME, predanoIme);
		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_PREZIME, predanoPrezime);
		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_ADRESA, predanaAdresa);
		startActivity(intent);
	}
}
