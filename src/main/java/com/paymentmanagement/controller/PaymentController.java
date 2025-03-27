package com.paymentmanagement.controller;

import com.paymentmanagement.entity.Payment;
import org.springframework.web.bind.annotation.*;
import com.paymentmanagement.service.PaymentService;
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process/{orderId}")
    public Payment processPayment(@PathVariable Long orderId, @RequestParam boolean isSuccess) {
        return paymentService.processPayment(orderId, isSuccess);
    }

    @GetMapping("/{orderId}")
    public Payment getPaymentDetails(@PathVariable Long orderId) {
        return paymentService.getPaymentDetails(orderId);
    }
}