package com.demo.springbootmongodb;

public class Address {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

    protected Address(){}

    public Address(String city, String country){
        this.city = city;
        this.country = country;
    }


}
