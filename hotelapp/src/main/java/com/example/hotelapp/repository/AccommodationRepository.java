package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Accommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccommodationRepository {

    private static final String insertAccommodationSql = "INSERT INTO accommodation (customer_id, room_id, check_in, check_out) VALUES (?,?,?,?)";
    private static final String updateAccommodationSql = "UPDATE accommodation SET customer_id = ? , room_id = ?, check_in = ?, check_out = ? WHERE id = ?";
    private static final String deleteAccommodationSql = "DELETE FROM accommodation WHERE id = ?";
    private static final String getAccommodationByIdSql = "SELECT * FROM accommodation WHERE id = ?";
    private static final String getAllAccommodationsSql = "SELECT * FROM accommodation";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Accommodation saveAccommodation(Accommodation accommodation) {
        jdbcTemplate.update(insertAccommodationSql, accommodation.getCustomerId(), accommodation.getRoomId(), accommodation.getCheckIn(), accommodation.getCheckOut());
        return accommodation;
    }

    public Accommodation updateAccommodation(Accommodation accommodation) {
        jdbcTemplate.update(updateAccommodationSql, accommodation.getCustomerId(), accommodation.getRoomId(), accommodation.getCheckIn(), accommodation.getCheckOut(), accommodation.getId());
        return accommodation;
    }

    public String deleteAccommodationById(int id) {
        jdbcTemplate.update(deleteAccommodationSql, id);
        return "deletion succeed";
    }

    public Accommodation getAccommodationById(int id) {
        return jdbcTemplate.queryForObject(getAccommodationByIdSql, (rs, rowNum) -> {

            return new Accommodation(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id"),
                    rs.getString("check_in"),
                    rs.getString("check_out"));
        }, id);
    }

    public List<Accommodation> getAllAccommodations() {
        return jdbcTemplate.query(getAllAccommodationsSql, (rs, rowNum) -> {
            return new Accommodation(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id"),
                    rs.getString("check_in"),
                    rs.getString("check_out"));
        });
    }
    
    
}
