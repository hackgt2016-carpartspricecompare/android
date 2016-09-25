package com.hackgt.partspricer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pranathi on 9/24/2016.
 */
public class Category implements Serializable {
	private String          name;
	private ArrayList<Part> parts;

	public Category () {

	}

	public Category (String name, ArrayList<Part> parts) {
		this.name = name;
		this.parts = parts;
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
}
