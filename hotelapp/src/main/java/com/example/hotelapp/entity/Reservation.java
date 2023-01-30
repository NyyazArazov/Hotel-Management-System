package com.example.hotelapp.entity;

public class Reservation {
    private int id;
    private int customerId;
    private int roomId;
    private String reservationDate;
    private int stayingDays;
    private String status;
    private String entryDate;

    public Reservation() {
    }

    public Reservation(int id, int customerId, int roomId, String reservationDate, int stayingDays, String status, String entryDate) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.reservationDate = reservationDate;
        this.stayingDays = stayingDays;
        this.status = status;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getStayingDays() {
        return stayingDays;
    }

    public void setStayingDays(int stayingDays) {
        this.stayingDays = stayingDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
