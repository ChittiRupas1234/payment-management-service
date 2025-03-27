package com.paymentmanagement.controller;

import com.paymentmanagement.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refund")

public class RefundController {
    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping("/{orderId}")
    public String refundPayment(@PathVariable Long orderId) {
        return refundService.processRefund(orderId);
    }
}