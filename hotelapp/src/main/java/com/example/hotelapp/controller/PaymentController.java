package com.example.hotelapp.controller;

import com.example.hotelapp.entity.Payment;
import com.example.hotelapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments(){
        return paymentRepository.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable int id){
        return paymentRepository.getPaymentById(id);
    }

    @DeleteMapping("/deletion/{id}")
    public String deletePaymentById(@PathVariable int id){
        return paymentRepository.deletePaymentById(id);
    }

    @PutMapping("/updatingPayment")
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentRepository.updatePayment(payment);
    }

    @PostMapping("/newPayment")
    public Payment savePayment(@RequestBody Payment payment){
        return paymentRepository.savePayment(payment);
    }
}
