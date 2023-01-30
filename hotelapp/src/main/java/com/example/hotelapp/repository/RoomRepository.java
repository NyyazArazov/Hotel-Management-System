package com.example.hotelapp.repository;

import com.example.hotelapp.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {
    private static final String insertRoomSql = "INSERT INTO room (hotel_id, room_no, cost,type,is_reserved) VALUES (?,?,?,?,?)";
    private static final String updateRoomSql = "UPDATE room SET hotel_id = ? , room_no = ?, cost = ?,type = ?, is_reserved = ? WHERE id = ?";
    private static final String deleteRoomSql = "DELETE FROM room WHERE id = ?";
    private static final String getRoomByIdSql = "SELECT * FROM room WHERE id = ?";
    private static final String getAllRoomsSql = "SELECT * FROM room";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Room saveRoom(Room room) { //isReserved false geliyo true olasa da
        jdbcTemplate.update(insertRoomSql, room.getHotelId(), room.getRoomNo(), room.getCost(), room.getType(),room.getReserved());
        return room;
    }

    public Room updateRoom(Room room) { //isReserved false geliyo true olasa da
        jdbcTemplate.update(updateRoomSql, room.getHotelId(), room.getRoomNo(), room.getCost(), room.getType(),room.getReserved(), room.getId());
        return room;
    }

    public String deleteRoomById(int id) {
        jdbcTemplate.update(deleteRoomSql, id);
        return "deletion succeed";
    }

    public Room getRoomById(int id) {
        return jdbcTemplate.queryForObject(getRoomByIdSql, (rs, rowNum) -> {

            return new Room(rs.getInt("id"),
                    rs.getInt("hotel_id"),
                    rs.getInt("room_no"),
                    rs.getFloat("cost"),
                    rs.getString("type"),
                    rs.getBoolean("is_Reserved"));
        }, id);
    }

    public List<Room> getAllRooms() {
        return jdbcTemplate.query(getAllRoomsSql, (rs, rowNum) -> {
            return new Room(rs.getInt("id"),
                    rs.getInt("hotel_id"),
                    rs.getInt("room_no"),
                    rs.getFloat("cost"),
                    rs.getString("type"),
                    rs.getBoolean("is_Reserved"));
        });
    }
}
