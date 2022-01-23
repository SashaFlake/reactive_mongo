package ru.attest.reactive_mongo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
public class LoginController {
    @GetMapping
    public Mono<String> login(Mono<Principal> principal){
        return principal.map(
                Principal::getName
        ).map(name -> String.format("Hello, %s", name));
    }
}
