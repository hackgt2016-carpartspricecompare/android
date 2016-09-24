package com.hackgt.partspricer;

import java.util.ArrayList;

/**
 * Created by Pranathi on 9/24/2016.
 */

public class Category {
    private String name;
    private ArrayList<Part> parts;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(){

    }
}
