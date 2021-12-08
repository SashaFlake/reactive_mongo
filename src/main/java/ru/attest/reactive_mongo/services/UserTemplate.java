package ru.attest.reactive_mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.User;
@Service
public class UserTemplate {
	@Autowired
	ReactiveMongoTemplate template;

	public Mono<User> findById(String id) {
		return template.findById(id, User.class);
	}

	public Flux<User> findAll() {
		return template.findAll(User.class);
	}
	public Mono<User> save(User user) {
		return template.save(user);
	}
}
