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
    private static ArrayList<Category> partCategories;

	public static ArrayList<Category> getPartCategories () {
		return partCategories;
	}

	static{
        partCategories = new ArrayList<>();



        ArrayList<Part> subPartCategoriesAC = new ArrayList<>();
        subPartCategoriesAC.add(new Part("Element","AC Filter","15781507"));
        partCategories.add(new Category("AC Filter", subPartCategoriesAC));

        ArrayList<Part> subPartCategoriesBulb = new ArrayList<>();
        subPartCategoriesBulb.add(new Part("Head Light","Bulb","1302"));
        subPartCategoriesBulb.add(new Part("Break Light","Bulb","2871"));
        partCategories.add(new Category("Bulb", subPartCategoriesBulb));

        ArrayList<Part> subPartCategoriesBlade = new ArrayList<>();
        subPartCategoriesBlade.add(new Part("Blade","Wiper Blade", "13000" ));
        partCategories.add(new Category("Blade", subPartCategoriesBlade));

        ArrayList<Part> subPartCategoriesCap = new ArrayList<>();
        subPartCategoriesCap.add(new Part());
        partCategories.add(new Category("Caps ", subPartCategoriesCap));


    }
}
