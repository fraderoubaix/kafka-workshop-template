package com.example.demo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericProducer<T> {
  private final KafkaTemplate<String, T> kafkaTemplate;

  public void sendMessage(String topicName, T object, String key) {
    Message<T> message =
        MessageBuilder.withPayload(object)
            .setHeader(KafkaHeaders.TOPIC, topicName)
            .setHeader(KafkaHeaders.KEY, key)
            .build();

    kafkaTemplate.send(message);
  }
}
