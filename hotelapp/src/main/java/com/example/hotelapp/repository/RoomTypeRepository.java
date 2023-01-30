package com.example.hotelapp.repository;

import com.example.hotelapp.entity.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoomTypeRepository {
    private static final String insertRoomTypeSql = "INSERT INTO room_type (type) VALUES (?)";
    private static final String updateRoomTypeSql = "UPDATE room_type SET type = ?  WHERE type = ?";
    private static final String deleteRoomTypeSql = "DELETE FROM room_type WHERE type = ?";
    private static final String getRoomTypeByIdSql = "SELECT * FROM room_type WHERE type = ?";
    private static final String getAllRoomTypesSql = "SELECT * FROM room_type";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RoomType saveRoomType(RoomType RoomType) {
        jdbcTemplate.update(insertRoomTypeSql, RoomType.getType());
        return RoomType;
    }

    public String deleteRoomTypeByType(String type) { //sıkıntılı silmiyo
        jdbcTemplate.update(deleteRoomTypeSql, type);
        return "deletion succeed";
    }

    public List<RoomType> getAllRoomTypes() {
        return jdbcTemplate.query(getAllRoomTypesSql, (rs, rowNum) -> {
            return new RoomType(
                    rs.getString("type"));

        });
    }
}
