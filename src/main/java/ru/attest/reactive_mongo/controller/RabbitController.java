package ru.attest.reactive_mongo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class RabbitController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @GetMapping(value = "sendMessage")
    public void sendMessage(){
        rabbitTemplate.convertAndSend("Hello");
    }
}
