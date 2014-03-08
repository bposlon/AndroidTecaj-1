package com.example.subota1.activities;

import java.util.ArrayList;




import com.example.subota1.R;
import com.example.subota1.models.UserModel;
import com.example.subota1.utils.C;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	private EditText mInputFirstNameEditText;
	private EditText mInputLastNameEditText;
	private RadioGroup mInputSexRadioGroup;
	private EditText mInputPhoneNumberEditText;

	private Button mAddButton;
	private Button mViewButton;

	private ArrayList<UserModel> mUsers	= new ArrayList<UserModel>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUi();
		initListeners();
	}

	@Override
	public void initUi() {
		mInputFirstNameEditText = (EditText) findViewById(R.id.activity_main_first_name_edittext);
		mInputLastNameEditText = (EditText) findViewById(R.id.activity_main_last_name_edittext);
		mInputSexRadioGroup = (RadioGroup) findViewById(R.id.activity_main_sex_radiogroup);
		mInputPhoneNumberEditText = (EditText) findViewById(R.id.activity_main_phone_number_edittext);

		mAddButton = (Button) findViewById(R.id.activity_main_add_button);
		mViewButton= (Button) findViewById(R.id.activity_main_view_button);

	}

	@Override
	public void initListeners() {
		mAddButton.setOnClickListener(mOnclClickListener);
		mViewButton.setOnClickListener(mOnclClickListener);

	}
	private OnClickListener mOnclClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_add_button:
				String firstName = mInputFirstNameEditText.getText().toString();
				String lastName = mInputLastNameEditText.getText().toString();
				String phoneNumber = mInputPhoneNumberEditText.getText().toString();
				
				UserModel user = createUsers(firstName, lastName, onRadioButtonClicked(), phoneNumber);
				addUserToUsersList(user);
				
				Toast.makeText(MainActivity.this, "User has been added, current size is:" + (mUsers.size()), Toast.LENGTH_SHORT).show();
				
				mInputFirstNameEditText.setText("");
				mInputLastNameEditText.setText("");
				mInputPhoneNumberEditText.setText("");
				
				break;
			case R.id.activity_main_view_button:
				startSecondActivity();
				break;
			}

		}
	};
	public String onRadioButtonClicked() {
	    int checkRadioButtonId=mInputSexRadioGroup.getCheckedRadioButtonId();
	    switch(checkRadioButtonId) {
	        case R.id.activity_main_sex_female_button:
	        	return "Žensko";
	        case R.id.activity_main_sex_male_button:
	            return "Muško";
	    }
		return null;
	}
	private UserModel createUsers(String firstName, String lastName, String sex, String phoneNumber){

		UserModel model = new UserModel();
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setSex(sex);
		model.setPhoneNumber(phoneNumber);
		return model;
	}
	private void addUserToUsersList(UserModel user){
		mUsers.add(user);
	}
	private void startSecondActivity(){
		Intent intent = new Intent(this, SecondActivity.class);

		intent.putParcelableArrayListExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER_MODEL, mUsers);
		startActivity(intent);
	}

}
