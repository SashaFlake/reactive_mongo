package ru.attest.reactive_mongo.rabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.attest.reactive_mongo.ReactiveMongoApplication;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
       // rabbitTemplate.convertAndSend(ReactiveMongoApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        //receiver.getLatch().await(100, TimeUnit.MILLISECONDS);
    }

}
