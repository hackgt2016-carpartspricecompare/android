package com.hackgt.partspricer;

/**
 * Created by Pranathi on 9/24/2016.
 */

public class Part {
    private String name;
    private String category;
    private String number;
    private double price;

    public Part () {
    }

    @Override
    public String toString () {
        return name;
    }

    public Part (String name, String category, String number) {
        this.name = name;
        this.category = category;
        this.number = number;
    }

    public Part (String name, String category, String number, double price) {
        this.name = name;
        this.category = category;
        this.number = number;
        this.price = price;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

    public String getNumber () {
        return number;
    }

    public void setNumber (String number) {
        this.number = number;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }
}
