package ru.attest.reactive_mongo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.attest.reactive_mongo.entities.AbstractEntity;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.util.FilterCollection;
import ru.attest.reactive_mongo.services.CommonService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static ru.attest.reactive_mongo.util.ClasspathConst.recognizeClass;


@RestController
@Slf4j
public class MarsEnterpriseController<T extends AbstractEntity> {

    @Autowired
    CommonService service;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @PostMapping(value = "{entityClass}/find",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
                    MediaType.ALL_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE}
    )
    @ResponseBody
    public Flux<?> find(@PathVariable("entityClass") String entityClass,
                        @RequestBody FilterCollection input){
        Class<?> clazz;
        try {
            clazz = recognizeClass(entityClass);
        }catch (ClassNotFoundException e){
            log.error(LocalDateTime.now()+": No entity found: "+ entityClass);
            return Flux.just(ResponseEntity.badRequest().body("No entity found: "+ entityClass));
        }
        return service.findByPredicates(input,clazz);
    }
    @GetMapping(value = "sendMessage")
    public void sendMessage(){
        rabbitTemplate.convertAndSend("Hello");
    }
}
