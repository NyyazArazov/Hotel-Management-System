package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Reservation;
import com.example.hotelapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/allReservations")
    public List<Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return reservationRepository.getReservationById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteReservationById(@PathVariable int id){
        return reservationRepository.deleteReservationById(id);
    }

    @PutMapping("/updatingReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationRepository.updateReservation(reservation);
    }

    @PostMapping("/newReservation")
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return reservationRepository.saveReservation(reservation);
    }
}
