package ru.attest.reactive_mongo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.Metaclass;
import ru.attest.reactive_mongo.util.FilterCollection;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class MetaclassHandler {
    ReactiveMongoTemplate template;
    public MetaclassHandler(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public Mono<ServerResponse> listMetaclass(ServerRequest request) {
       Flux<FilterCollection> filterCollection = request.bodyToFlux(FilterCollection.class);
        return null;
    }

    public Mono<ServerResponse> createMetaclass(ServerRequest request) {
        Mono<Metaclass> metaclass = request.bodyToMono(Metaclass.class);

        return metaclass.flatMap(user ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(template.save(user),Metaclass.class)
        );
       // return ok().build(temp late.save(metaclass));
    }

    public Mono<ServerResponse> getMetaclass(ServerRequest request) {
        Flux<FilterCollection> filterCollection = request.bodyToFlux(FilterCollection.class);
        return null;
    }
}
