package ru.attest.reactive_mongo.entities;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

public interface MetaclassInfo {
	public Flux<Metaclass> getMetaclass(ReactiveMongoTemplate template);
	public Flux<Metaclass> setMetaclass();
}
