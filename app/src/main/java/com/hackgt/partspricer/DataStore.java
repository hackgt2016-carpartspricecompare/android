package com.hackgt.partspricer;

import java.util.ArrayList;

/**
 * Created by Joshua King on 9/24/16.
 */
public class DataStore {
	private static ArrayList<Car> cars;

	public static ArrayList<Car> getCars () {
		return cars;
	}

	public static void setCars (ArrayList<Car> cars) {
		DataStore.cars = cars;
	}
}
