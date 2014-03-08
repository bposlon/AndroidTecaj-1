package com.example.subota1.adapters;

import java.util.ArrayList;

import com.example.subota1.R;
import com.example.subota1.models.UserModel;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter
{

	private Context mContext;
	private ArrayList<UserModel> mUsers;


	public UserAdapter(Context context, ArrayList<UserModel> users) throws IllegalArgumentException {
		if(context == null){
			throw new IllegalArgumentException("kontext je prazan");
		}
		if (users == null) {
			throw new IllegalArgumentException("majstore napuni listu");
		}
		mContext = context;
		mUsers = users;
	}

	@Override
	public int getCount() {
		return mUsers.size();
	}

	@Override
	public UserModel getItem(int position) {
		return mUsers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view= LayoutInflater.from(mContext).inflate(R.layout.item_activity_second, parent, false);

		TextView firstNameTextView = (TextView) view.findViewById(R.id.item_activity_second_firstName_textview);
		TextView lastNameTextView = (TextView) view.findViewById(R.id.item_activity_second_lastName_textview);
		TextView sexTextView = (TextView) view.findViewById(R.id.item_activity_second_sex_textview);
		TextView phoneNumberTextView = (TextView) view.findViewById(R.id.item_activity_second_phoneNumber_textview);

		UserModel korisnik = getItem(position);
		if (korisnik != null){
			
			String tempFirstName = korisnik.getFirstName();
			if( tempFirstName != null){
				firstNameTextView.setText(tempFirstName);
			}else {
				firstNameTextView.setText("Prazno");
			}
			
			String tempLastName = korisnik.getLastName();
			if( tempLastName != null){
				lastNameTextView.setText(tempLastName);
			}else {
				lastNameTextView.setText("Prazno");
			}
			
			String tempSex = korisnik.getSex();
			if( tempSex != null){
				sexTextView.setText(tempSex);
			}else {
				sexTextView.setText("Prazno");
			}
			String tempPhoneNumber = korisnik.getPhoneNumber();
			if( tempPhoneNumber != null){
				phoneNumberTextView.setText(tempPhoneNumber);
			}else {
				phoneNumberTextView.setText("Prazno");
			}
		}
		return view;
	}


}
