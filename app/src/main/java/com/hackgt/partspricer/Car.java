package com.hackgt.partspricer;

import org.json.JSONException;
import org.json.JSONObject;

public class Car {
    private String onstarStatus;
    private String make;
    private String model;
    private String vin;
    private String manufacturer;
    private int    year;

    Car (String vin, String make, String model, int year, String manufacturer, String onstarStatus) {

        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.onstarStatus = onstarStatus;
    }

    public Car (JSONObject o) throws JSONException {
        this(o.getString("vin"), o.getString("make"), o.getString("model"), Integer.valueOf(o.getString("year")), o.getString("manufacturer"), o.getString("onstarStatus"));
    }

    public String getVin () {
        return vin;
    }

    public void setVin (String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOnstarStatus () {
        return onstarStatus;
    }

    public void setOnstarStatus (String onstarStatus) {
        this.onstarStatus = onstarStatus;
    }
}