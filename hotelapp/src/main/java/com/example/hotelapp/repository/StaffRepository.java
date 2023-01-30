package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepository {
    private static final String insertStaffSql = "INSERT INTO staff (full_name ,hotel_id) VALUES (?,?)";
    private static final String updateStaffSql = "UPDATE staff SET full_name = ? ,hotel_id = ? WHERE id = ?";
    private static final String deleteStaffSql = "DELETE FROM staff WHERE id = ?";
    private static final String getStaffByIdSql = "SELECT * FROM staff WHERE id = ?";
    private static final String getAllStaffsSql = "SELECT * FROM staff";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Staff saveStaff(Staff staff) {
        jdbcTemplate.update(insertStaffSql, staff.getFullName(), staff.getHotelId());
        return staff;
    }

    public Staff updateStaff(Staff staff) {
        jdbcTemplate.update(updateStaffSql, staff.getFullName(), staff.getHotelId(), staff.getId());
        return staff;
    }

    public String deleteStaffById(int id) {
        jdbcTemplate.update(deleteStaffSql, id);
        return "deletion succeed";
    }

    public Staff getStaffById(int id) {
        return jdbcTemplate.queryForObject(getStaffByIdSql, (rs, rowNum) -> {
            return new Staff(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getInt("hotel_id"));
        }, id);
    }

    public List<Staff> getAllStaffs() {
        return jdbcTemplate.query(getAllStaffsSql, (rs, rowNum) -> {
            return new Staff(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getInt("hotel_id"));
        });
    }


}
