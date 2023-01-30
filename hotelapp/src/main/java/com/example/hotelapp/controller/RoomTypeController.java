package com.example.hotelapp.controller;

import com.example.hotelapp.entity.RoomType;
import com.example.hotelapp.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomTypes")
public class RoomTypeController {
    @Autowired
    RoomTypeRepository roomTypeRepository;

    @GetMapping("/allRoomTypes")
    public List<RoomType> getAllRoomTypes(){
        return roomTypeRepository.getAllRoomTypes();
    }

    @DeleteMapping("/deletion/{type}")
    public String deleteRoomTypeByType(@PathVariable String type){
        return roomTypeRepository.deleteRoomTypeByType(type);
    }

    @PostMapping("/newRoomType")
    public RoomType saveRoomType(@RequestBody RoomType roomType){
        return roomTypeRepository.saveRoomType(roomType);
    }
}
