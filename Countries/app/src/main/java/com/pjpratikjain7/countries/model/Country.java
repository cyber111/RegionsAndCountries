package com.pjpratikjain7.countries.model;

public class Country {

    private String region;
    private String name;

    public Country(String region, String name) {
        this.region = region;
        this.name = name;
    }

    public Country() {
    }



    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "region='" + region + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
