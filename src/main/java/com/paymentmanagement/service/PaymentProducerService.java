package com.paymentmanagement.service;


import com.paymentmanagement.dto.PaymentEvent;
import com.paymentmanagement.dto.RefundEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {
    private final KafkaTemplate<String, PaymentEvent> paymentKafkaTemplate;
    private final KafkaTemplate<String, RefundEvent> refundKafkaTemplate;

    public PaymentProducerService(
            KafkaTemplate<String, PaymentEvent> paymentKafkaTemplate,
            KafkaTemplate<String, RefundEvent> refundKafkaTemplate) {
        this.paymentKafkaTemplate = paymentKafkaTemplate;
        this.refundKafkaTemplate = refundKafkaTemplate;
    }

    public void sendPaymentEvent(PaymentEvent event) {
        paymentKafkaTemplate.send("payment-topic", event);
    }

    public void sendRefundEvent(RefundEvent event) {
        refundKafkaTemplate.send("refund-topic", event);
    }
}