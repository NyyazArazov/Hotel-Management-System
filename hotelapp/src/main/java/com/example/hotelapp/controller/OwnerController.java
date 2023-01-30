package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Owner;
import com.example.hotelapp.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("/allOwners")
    public List<Owner> getAllOwners(){
        return ownerRepository.getAllOwners();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable int id){
        return ownerRepository.getOwnerById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteOwnerById(@PathVariable int id){
        return ownerRepository.deleteOwnerById(id);
    }

    @PutMapping("/updatingOwner")
    public Owner updateOwner(@RequestBody Owner owner){
        return ownerRepository.updateOwner(owner);
    }

    @PostMapping("/newOwner")
    public Owner saveOwner(@RequestBody Owner owner){
        return ownerRepository.saveOwner(owner);
    }
}
