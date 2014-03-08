package com.example.subota1.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;



import com.example.subota1.R;
import com.example.subota1.adapters.UserAdapter;
import com.example.subota1.models.UserModel;
import com.example.subota1.utils.C;

public class SecondActivity extends BaseActivity{

	private ArrayList<UserModel> mUserItems;
	
	private ListView mListView;
	private UserAdapter mUserAdapter;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initUi();

		Intent intent = getIntent();
		if (intent !=null){
			initExtras(intent);
		}
		mUserAdapter = new UserAdapter(this, mUserItems);
		mListView.setAdapter(mUserAdapter);
	}
	private void initExtras(Intent intent) {
		mUserItems=intent.getParcelableArrayListExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER_MODEL);		
	}
	@Override
	public void initUi() {
		mListView = (ListView) findViewById(R.id.activity_second_listview);
		
	}
	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

}
