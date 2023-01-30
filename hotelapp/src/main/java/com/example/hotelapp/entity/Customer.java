package com.example.hotelapp.entity;

public class Customer {
    private int id;
    private String fullName;
    private String mobile;
    private String mail;

    public Customer() {
    }

    public Customer(int id, String fullName, String mobile, String mail) {
        this.id = id;
        this.fullName = fullName;
        this.mobile = mobile;
        this.mail = mail;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
