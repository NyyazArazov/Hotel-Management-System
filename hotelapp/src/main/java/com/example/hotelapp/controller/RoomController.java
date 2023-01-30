package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Room;
import com.example.hotelapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/allRooms")
    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id){
        return roomRepository.getRoomById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteRoomById(@PathVariable int id){
        return roomRepository.deleteRoomById(id);
    }

    @PutMapping("/updatingRoom")
    public Room updateRoom(@RequestBody Room room){
        return roomRepository.updateRoom(room);
    }

    @PostMapping("/newRoom")
    public Room saveRoom(@RequestBody Room room){
        return roomRepository.saveRoom(room);
    }
}
