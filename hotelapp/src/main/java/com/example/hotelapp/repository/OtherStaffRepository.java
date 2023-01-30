package com.example.hotelapp.repository;

import com.example.hotelapp.entity.OtherStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OtherStaffRepository {
    private static final String insertOtherStaffSql = "INSERT INTO other_staff (id, type) VALUES (?,?)";
    private static final String updateOtherStaffSql = "UPDATE other_staff SET type = ?  WHERE id = ?";
    private static final String deleteOtherStaffSql = "DELETE FROM other_staff WHERE id = ?";
    private static final String getOtherStaffByIdSql = "SELECT * FROM other_staff WHERE id = ?";
    private static final String getAllOtherStaffsSql = "SELECT * FROM other_staff";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OtherStaff saveOtherStaff(OtherStaff otherStaff) {
        jdbcTemplate.update(insertOtherStaffSql, otherStaff.getId(),otherStaff.getType());
        return otherStaff;
    }

    public OtherStaff updateOtherStaff(OtherStaff otherStaff) {
        jdbcTemplate.update(updateOtherStaffSql, otherStaff.getType(),otherStaff.getId());
        return otherStaff;
    }

    public String deleteOtherStaffById(int id) {
        jdbcTemplate.update(deleteOtherStaffSql, id);
        return "deletion succeed";
    }

    public OtherStaff getOtherStaffById(int id) {
        return jdbcTemplate.queryForObject(getOtherStaffByIdSql, (rs, rowNum) -> {

            return new OtherStaff(rs.getInt("id"),
                    rs.getString("type"));
        }, id);
    }

    public List<OtherStaff> getAllOtherStaffs() {
        return jdbcTemplate.query(getAllOtherStaffsSql, (rs, rowNum) -> {
            return new OtherStaff(rs.getInt("id"),
                    rs.getString("type"));
        });
    }

}
