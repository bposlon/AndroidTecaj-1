package com.example.subota1.adapters;

import java.util.ArrayList;

import com.example.subota1.R;
import com.example.subota1.models.UserModel;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter
{

	private Context mContext;
	private ArrayList<UserModel> mUsers;
	private ViewHolder mViewHolder;

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
		if (convertView == null) {
			mViewHolder=new ViewHolder();
			
			convertView=LayoutInflater.from(mContext).inflate(R.layout.item_activity_second, parent, false);
			initViewHolderChildWidgets(convertView);
			convertView.setTag(mViewHolder);
		}else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		
		UserModel user = getItem(position);
		if (user != null) {
			initViewHolderChildWidgets(user);
		}
		return convertView;
	}
	private void initViewHolderChildWidgets(UserModel user) {
		String firstName = user.getFirstName();
		if (firstName != null){
		mViewHolder.firstNameTextView.setText(firstName);
		}
		String lastName = user.getLastName();
		if (lastName != null){
		mViewHolder.lastNameTextView.setText(lastName);
		}
		String sex = user.getSex();
		if (sex != null){
		mViewHolder.sexTextView.setText(sex);
		}
		String phoneNumber = user.getPhoneNumber();
		if (phoneNumber != null){
		mViewHolder.phoneNumberTextView.setText(phoneNumber);
		}
	}

	private void initViewHolderChildWidgets(View convertView) {
		mViewHolder.firstNameTextView = (TextView) convertView.findViewById(R.id.item_activity_second_firstName_textview);
		mViewHolder.lastNameTextView = (TextView) convertView.findViewById(R.id.item_activity_second_lastName_textview);
		mViewHolder.sexTextView = (TextView) convertView.findViewById(R.id.item_activity_second_sex_textview);
		mViewHolder.phoneNumberTextView = (TextView) convertView.findViewById(R.id.item_activity_second_phoneNumber_textview);
		mViewHolder.userImageView = (ImageView) convertView.findViewById(R.id.item_activity_second_imageView);
		
	}
	public static class ViewHolder {
		private TextView firstNameTextView;
		private TextView lastNameTextView;
		private TextView sexTextView;
		private TextView phoneNumberTextView;
		private ImageView userImageView;
	}

}
