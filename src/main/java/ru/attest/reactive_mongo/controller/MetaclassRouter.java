package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.handlers.MetaclassHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration(proxyBeanMethods = false)

public class MetaclassRouter {
    @Autowired
    ReactiveMongoTemplate template;
    @Bean
    RouterFunction<ServerResponse> getMetaClassRouter() {
        MetaclassHandler handler = new MetaclassHandler(template);


        RouterFunction<ServerResponse> route = route()
                .POST("/metaclass", handler::createMetaclass)
                .build();
        return route;

    }
}
