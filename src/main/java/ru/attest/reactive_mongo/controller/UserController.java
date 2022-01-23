package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.services.MarsEnterpriseService;
import ru.attest.reactive_mongo.services.UserTemplate;
import ru.attest.reactive_mongo.util.MarsEnterpriseFakeGenerator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {
	@Autowired
	UserTemplate template;

	@Autowired
	MarsEnterpriseService marsEnterpriseService;
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
/*
	@GetMapping(value = "gen",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					MediaType.ALL_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public Flux<MarsEnterprise>generateEnt() {
		List<MarsEnterprise> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			MarsEnterprise marsEnterprise = MarsEnterpriseFakeGenerator.randomMarsEnterprise();
			list.add(marsEnterprise);
			marsEnterpriseService.getTemplate().save(marsEnterprise);
		}
		return Flux.fromIterable(list);
	}

 */

}
