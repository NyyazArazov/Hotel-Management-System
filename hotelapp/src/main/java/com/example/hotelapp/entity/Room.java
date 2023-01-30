package com.example.hotelapp.entity;

public class Room {
    private int id;
    private int hotelId;
    private int roomNo;
    private Float cost;
    private String type;
    private boolean isReserved;

    public Room() {

    }

    public Room(int id, int hotelId, int roomNo, Float cost, String type, boolean isReserved) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomNo = roomNo;
        this.cost = cost;
        this.type = type;
        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
