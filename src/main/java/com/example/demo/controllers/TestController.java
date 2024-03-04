package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.producer.GenericProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  GenericProducer<User> userProducer;

  @Value("${app.kafka.topic.user.name}")
  String topicName;

  public TestController(GenericProducer<User> userProducer) {
    this.userProducer = userProducer;
  }

  @GetMapping()
  public void triggerProducer() {
    userProducer.sendMessage(topicName, new User("bob", "toto", "bob.toto@test.fr"), "new-user");
  }
}
