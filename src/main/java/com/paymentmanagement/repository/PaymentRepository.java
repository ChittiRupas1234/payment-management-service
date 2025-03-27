package com.paymentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paymentmanagement.entity.Payment;
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long orderId);
}
