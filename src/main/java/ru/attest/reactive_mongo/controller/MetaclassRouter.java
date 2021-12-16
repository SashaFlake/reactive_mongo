package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.handlers.MetaclassHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
@Configuration(proxyBeanMethods = false)

public class MetaclassRouter {
    @Autowired
    ReactiveMongoTemplate template;
    @Bean
    RouterFunction<ServerResponse> getMetaClassRouter() {
        MetaclassHandler handler = new MetaclassHandler(template);


        RouterFunction<ServerResponse> route = route()
               // .GET("/person/{id}", accept(APPLICATION_JSON), handler::getPerson)
               // .GET("/person", accept(APPLICATION_JSON), handler::listPeople)
                .POST("/metaclass", handler::createMetaclass)
                .build();
        return route;

        /*
        return route(GET("/MetaClass"),
                req -> ok().body(
                        //template.findByPred(), User.class)
                        //req -> ok().
                        template.findByAll(), User.class)


         */


        //.findAll(), User.class));

    }
}
