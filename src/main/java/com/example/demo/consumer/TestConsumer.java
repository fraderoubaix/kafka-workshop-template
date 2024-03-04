package com.example.demo.consumer;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestConsumer {
    @KafkaListener(topics = "${app.kafka.topic.user.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info("We receive a new user with firstname : {} lastname : {} email : {}", user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
