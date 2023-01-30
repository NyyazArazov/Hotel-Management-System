package com.example.hotelapp.entity;

public class Staff {

    private int id;
    private String fullName;
    private int hotelId;

    public Staff(int id, String fullName, int hotelId) {
        this.id = id;
        this.fullName = fullName;
        this.hotelId = hotelId;
    }

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }










}
