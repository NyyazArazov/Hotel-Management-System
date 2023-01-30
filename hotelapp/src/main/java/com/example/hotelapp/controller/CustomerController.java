package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Customer;
import com.example.hotelapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerRepository.getCustomerById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deleteCustomerById(@PathVariable int id){
        return customerRepository.deleteCustomerById(id);
    }

    @PutMapping("/updatingCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    @PostMapping("/newCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.saveCustomer(customer);
    }
}
