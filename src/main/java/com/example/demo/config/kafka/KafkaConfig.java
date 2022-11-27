package com.example.demo.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
public class KafkaConfig {
    @Value("${kafka.topic.transaction-topic}")
    String transactionTopic;


    @Bean
    public RecordMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    
    @Bean
    public NewTopic myTopic2() {
        return new NewTopic(transactionTopic, 1, (short) 1);
    }
}