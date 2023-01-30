package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepository {
    private static final String insertHotelSql = "INSERT INTO hotel (name, location, type) VALUES (?,?,?)";
    private static final String updateHotelSql = "UPDATE hotel SET name = ? , location = ?, type = ? WHERE id = ?";
    private static final String deleteHotelSql = "DELETE FROM hotel WHERE id = ?";
    private static final String getHotelByIdSql = "SELECT * FROM hotel WHERE id = ?";
    private static final String getAllHotelsSql = "SELECT * FROM hotel";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Hotel saveHotel(Hotel hotel) {
        jdbcTemplate.update(insertHotelSql, hotel.getName(), hotel.getLocation(),hotel.getType());
        return hotel;
    }

    public Hotel updateHotel(Hotel hotel) {
        jdbcTemplate.update(updateHotelSql, hotel.getName(), hotel.getLocation(),hotel.getType(), hotel.getId());
        return hotel;
    }

    public String deleteHotelById(int id) {
        jdbcTemplate.update(deleteHotelSql, id);
        return "deletion succeed";
    }

    public Hotel getHotelById(int id) {
        return jdbcTemplate.queryForObject(getHotelByIdSql, (rs, rowNum) -> {

            return new Hotel(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("type"));
        }, id);
    }

    public List<Hotel> getAllHotels() {
        return jdbcTemplate.query(getAllHotelsSql, (rs, rowNum) -> {
            return new Hotel(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("type"));
        });
    }
    
}
