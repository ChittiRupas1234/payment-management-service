package com.paymentmanagement.service;

import com.paymentmanagement.dto.PaymentEvent;
import com.paymentmanagement.entity.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.paymentmanagement.repository.PaymentRepository;
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentProducerService producerService;

    public PaymentService(PaymentRepository paymentRepository, PaymentProducerService producerService) {
        this.paymentRepository = paymentRepository;
        this.producerService = producerService;
    }

    @Transactional
    public Payment processPayment(Long orderId, boolean isSuccess) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setStatus(isSuccess ? "SUCCESS" : "FAILED");
        payment.setPaymentSuccessful(isSuccess);
        Payment savedPayment = paymentRepository.save(payment);

        // Publish Payment Event to Kafka
        producerService.sendPaymentEvent(new PaymentEvent(savedPayment.getOrderId(), savedPayment.getStatus(), savedPayment.isPaymentSuccessful()));

        return savedPayment;
    }

    public Payment getPaymentDetails(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
