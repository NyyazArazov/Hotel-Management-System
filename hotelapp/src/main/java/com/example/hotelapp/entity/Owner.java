package com.example.hotelapp.entity;

public class Owner {


    private int id;
    private String tax;


    public Owner() {
    }

    public Owner(int id, String tax) {
        this.id = id;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

}
