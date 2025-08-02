package com.redcell;

// Represents a generic user
public class User {

    // Attributes
    private String name;
    private String area;

    // Constructor
    public User(String name, String area) {
        this.name = name;
        this.area = area;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}