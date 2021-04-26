package com.practice.model;

public class Passenger {
    private int id;

    private String name;
    private String country;

    public Passenger(int id) {
        this.id = id;
    }

    public Passenger() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Passenger id = " + id + " name : " + name + " from " + country;
    }
}
