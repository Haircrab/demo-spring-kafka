package com.example.demo.controller;

import com.example.demo.model.Transaction.Transaction;
import com.example.demo.model.Transaction.TransactionDto;
import com.example.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Value("${kafka.topic.transaction-topic}")
    private String transactionTopic;

    @Autowired
    private KafkaProducerService producer;


    @PostMapping
    public String sendTransaction(@RequestBody TransactionDto body) {
        UUID uuid = UUID.randomUUID();

        Transaction transaction = new Transaction(
                uuid.toString(),
                new Date(),
                body.getAmountWithCurr(),
                body.getIban(),
                body.getDescription()
        );
        this.producer.sendMessage(transactionTopic, transaction);
        return uuid.toString();
    }

    @GetMapping
    public List<Transaction> getTransaction(@RequestParam String pageSize, @RequestParam String pageNumber) {
        return new ArrayList<>();
    }
}
