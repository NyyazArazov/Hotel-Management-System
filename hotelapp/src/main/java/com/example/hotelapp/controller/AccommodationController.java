package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Accommodation;
import com.example.hotelapp.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    @Autowired
    AccommodationRepository accommodationRepository;

    @GetMapping("/allAccommodations")
    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.getAllAccommodations();
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodationById(@PathVariable int id){
        return accommodationRepository.getAccommodationById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteAccommodationById(@PathVariable int id){
        return accommodationRepository.deleteAccommodationById(id);
    }

    @PutMapping("/updatingAccommodation")
    public Accommodation updateAccommodation(@RequestBody Accommodation accommodation){
        return accommodationRepository.updateAccommodation(accommodation);
    }

    @PostMapping("/newAccommodation")
    public Accommodation saveAccommodation(@RequestBody Accommodation accommodation){
        return accommodationRepository.saveAccommodation(accommodation);
    }
}
