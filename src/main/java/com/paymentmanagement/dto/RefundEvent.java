package com.paymentmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundEvent {
    private Long orderId;
    private String status;  // REFUNDED
}