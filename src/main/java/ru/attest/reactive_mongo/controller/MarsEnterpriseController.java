package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.entities.mars.enterprise.MarsEnterprise;

public class MarsEnterpriseController {
    @Autowired
    ReactiveMongoTemplate template;
     /*   public Mono<ResponseEntity<MarsEnterprise>> save(@RequestBody MarsEnterprise input){

            return template.save(user)
                    .map(user1 -> new ResponseEntity<>(user1, HttpStatus.ACCEPTED))
                    .defaultIfEmpty(new ResponseEntity<>(user, HttpStatus.NOT_FOUND));
        }

      */
    }
