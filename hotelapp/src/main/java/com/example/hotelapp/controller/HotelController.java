package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Hotel;
import com.example.hotelapp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/allHotels")
    public List<Hotel> getAllHotels(){
        return hotelRepository.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable int id){
        return hotelRepository.getHotelById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteHotelById(@PathVariable int id){
        return hotelRepository.deleteHotelById(id);
    }

    @PutMapping("/updatingHotel")
    public Hotel updateHotel(@RequestBody Hotel hotel){
        return hotelRepository.updateHotel(hotel);
    }

    @PostMapping("/newHotel")
    public Hotel saveHotel(@RequestBody Hotel hotel){
        return hotelRepository.saveHotel(hotel);
    }
}
