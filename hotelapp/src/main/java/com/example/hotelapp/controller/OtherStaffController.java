package com.example.hotelapp.controller;

import com.example.hotelapp.entity.OtherStaff;
import com.example.hotelapp.repository.OtherStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherStaffs")
public class OtherStaffController {

    @Autowired
    OtherStaffRepository otherStaffRepository;

    @GetMapping("/allOtherStaffs")
    public List<OtherStaff> getAllOtherStaffs(){
        return otherStaffRepository.getAllOtherStaffs();
    }

    @GetMapping("/{id}")
    public OtherStaff getOtherStaffById(@PathVariable int id){
        return otherStaffRepository.getOtherStaffById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteOtherStaffById(@PathVariable int id){
        return otherStaffRepository.deleteOtherStaffById(id);
    }

    @PutMapping("/updatingOtherStaff")
    public OtherStaff updateOtherStaff(@RequestBody OtherStaff otherStaff){
        return otherStaffRepository.updateOtherStaff(otherStaff);
    }

    @PostMapping("/newOtherStaff")
    public OtherStaff saveOtherStaff(@RequestBody OtherStaff otherStaff){
        return otherStaffRepository.saveOtherStaff(otherStaff);
    }
}
