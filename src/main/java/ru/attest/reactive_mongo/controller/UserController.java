package ru.attest.reactive_mongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.Group;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.services.UserTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {
	@Autowired
	UserTemplate template;

	@PostMapping(value = "User/Save",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					MediaType.ALL_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public Mono<ResponseEntity<User>> save(@RequestBody User user){
		return template.save(user)
				.map(user1 -> new ResponseEntity<>(user1, HttpStatus.ACCEPTED))
				.defaultIfEmpty(new ResponseEntity<>(user, HttpStatus.NOT_FOUND));
	}

	@GetMapping(value = "User/FindAll",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					MediaType.ALL_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public Flux<User> findAll(){
		return template.findAll();
	}

}
