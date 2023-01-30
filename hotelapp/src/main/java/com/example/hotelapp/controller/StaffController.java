package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Staff;
import com.example.hotelapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/allStaffs")
    public List<Staff> getAllStaffs(){
        return staffRepository.getAllStaffs();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable int id){
        return staffRepository.getStaffById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteStaffById(@PathVariable int id){
        return staffRepository.deleteStaffById(id);
    }

    @PutMapping("/updatingStaff")
    public Staff updateStaff(@RequestBody Staff staff){
        return staffRepository.updateStaff(staff);
    }

    @PostMapping("/newStaff")
    public Staff saveStaff(@RequestBody Staff staff){
        return staffRepository.saveStaff(staff);
    }

}
