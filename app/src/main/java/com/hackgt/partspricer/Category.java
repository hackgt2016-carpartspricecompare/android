package com.hackgt.partspricer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Pranathi on 9/24/2016.
 */
public class Category implements Parcelable {
	private String          name;
	private ArrayList<Part> parts;

	public Category () {

	}

	public Category (String name, ArrayList<Part> parts) {
		this.name = name;
		this.parts = parts;
	}

	public static final Creator<Category> CREATOR = new Creator<Category>() {
		@Override
		public Category createFromParcel (Parcel in) {
			return new Category(in);
		}

		@Override
		public Category[] newArray (int size) {
			return new Category[size];
		}
	};

	protected Category (Parcel in) {
		name = in.readString();
		parts = (ArrayList<Part>) in.readSerializable();
	}

	public ArrayList<Part> getParts () {
		return parts;
	}

	public void setParts (ArrayList<Part> parts) {
		this.parts = parts;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	@Override
	public int describeContents () {
		return 0;
	}

	@Override
	public void writeToParcel (Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeSerializable(parts);
	}
}
