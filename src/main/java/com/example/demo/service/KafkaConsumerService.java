package com.example.demo.service;

import com.example.demo.model.Transaction.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${kafka.topic.transaction-topic}")
    private String transactionTopic;
    

    @KafkaListener(topics = {"${kafka.topic.transaction-topic}"}, groupId = "group2")
    public void consumeMessage2(Transaction transaction) {
        log.info("Consumer consume topic: {} message -> {}", transactionTopic, transaction.toString());
    }
}
