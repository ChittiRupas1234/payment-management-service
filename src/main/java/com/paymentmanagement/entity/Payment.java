package com.paymentmanagement.entity;


import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private String status;  // SUCCESS, FAILED
    private boolean isPaymentSuccessful;
}