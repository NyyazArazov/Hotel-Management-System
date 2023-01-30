package com.example.hotelapp.entity;

public class Payment {
    private int id;
    private Float amount;
    private String date;
    private int accommodationId;

    public Payment() {
    }

    public Payment(int id, Float amount, String date, int accommodationId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.accommodationId = accommodationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }
}
