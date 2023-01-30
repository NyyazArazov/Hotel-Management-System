package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {
    private static final String insertReservationSql = "INSERT INTO reservation (customer_id, room_id, reservation_date, entry_date, staying_days, status) VALUES (?,?,?,?,?,?)";
    private static final String updateReservationSql = "UPDATE reservation SET customer_id = ? , room_id = ?, reservation_date = ?, entry_date = ?,staying_days = ?, status =?  WHERE id = ?";
    private static final String deleteReservationSql = "DELETE FROM reservation WHERE id = ?";
    private static final String getReservationByIdSql = "SELECT * FROM reservation WHERE id = ?";
    private static final String getAllReservationsSql = "SELECT * FROM reservation";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Reservation saveReservation(Reservation reservation) {
        jdbcTemplate.update(insertReservationSql, reservation.getCustomerId(), reservation.getRoomId(), reservation.getReservationDate(), reservation.getEntryDate(), reservation.getStayingDays(), reservation.getStatus());
        return reservation;
    }

    public Reservation updateReservation(Reservation reservation) {
        jdbcTemplate.update(updateReservationSql, reservation.getCustomerId(), reservation.getRoomId(), reservation.getReservationDate(), reservation.getEntryDate(), reservation.getStayingDays(), reservation.getStatus(), reservation.getId());
        return reservation;
    }

    public String deleteReservationById(int id) {
        jdbcTemplate.update(deleteReservationSql, id);
        return "deletion succeed";
    }

    public Reservation getReservationById(int id) {
        return jdbcTemplate.queryForObject(getReservationByIdSql, (rs, rowNum) -> {

            return new Reservation(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id"),
                    rs.getString("reservation_date"),
                    rs.getInt("staying_days"),
                    rs.getString("status"),
                    rs.getString("entry_date"));
        }, id);
    }

    public List<Reservation> getAllReservations() {
        return jdbcTemplate.query(getAllReservationsSql, (rs, rowNum) -> {
            return new Reservation(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id"),
                    rs.getString("reservation_date"),
                    rs.getInt("staying_days"),
                    rs.getString("status"),
                    rs.getString("entry_date"));
        });
    }
}
