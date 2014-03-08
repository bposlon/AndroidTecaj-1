package com.example.subota1.models;

import android.os.Parcel;
import android.os.Parcelable;


public class UserModel implements Parcelable {

	private String firstName;
	private String lastName;
	private String sex;
	private String phoneNumber;
	
	public UserModel() {

	}
	
	private UserModel(Parcel in) {
		firstName=in.readString();
		lastName=in.readString();
		sex=in.readString();
		phoneNumber=in.readString();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeString(sex);
		dest.writeString(phoneNumber);
	}
	public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {

		@Override
		public UserModel createFromParcel(Parcel source) {
			return new UserModel(source);
		}

		@Override
		public UserModel[] newArray(int size) {
			return new UserModel[size];
		}
	};
}
