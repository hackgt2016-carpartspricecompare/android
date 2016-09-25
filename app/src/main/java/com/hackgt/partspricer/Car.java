package com.hackgt.partspricer;

/**
 * Created by Sri on 9/24/2016.
 */

public class Car {

    private String vin;
    private String make;
    private String model;
    private int year;
    private String manufacturer;
    private String onstartStatus;

    Car(String vin, String make, String model, int year, String manufacturer,
        String onstartStatus, String url){

        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.onstartStatus = onstartStatus;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
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

    public String getOnstartStatus() {
        return onstartStatus;
    }

    public void setOnstartStatus(String onstartStatus) {
        this.onstartStatus = onstartStatus;
    }

   }
