package ru.attest.reactive_mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.entities.MarsEnterprise;

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
	public Mono<User> save(Mono<User> user) {
		return template.save(user);
	}

	public Flux<MarsEnterprise> findPageble(){
		Query query = new Query();
		// query.addCriteria(Criteria.where(input.getFilters().get(0).getField())
		//         .is(input.getFilters().get(0).getValues()));
		//   query.addCriteria(TemplateCriteriaCommon.getCriteria(input));
		query.with(Pageable.ofSize(20).withPage(1));
		return template.find(query,MarsEnterprise.class);
	}
}
