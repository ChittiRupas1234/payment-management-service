package com.paymentmanagement.service;



import com.paymentmanagement.dto.RefundEvent;
import org.springframework.stereotype.Service;

@Service
public class RefundService {
    private final PaymentProducerService producerService;

    public RefundService(PaymentProducerService producerService) {
        this.producerService = producerService;
    }

    public String processRefund(Long orderId) {
        producerService.sendRefundEvent(new RefundEvent(orderId, "REFUNDED"));
        return "Refund processed successfully!";
    }
}