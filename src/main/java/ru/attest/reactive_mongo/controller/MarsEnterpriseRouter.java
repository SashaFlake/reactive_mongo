package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import ru.attest.reactive_mongo.handlers.MarsEnterpriseHandler;

@Configuration(proxyBeanMethods = false)
public class MarsEnterpriseRouter {
    @Autowired
    ReactiveMongoTemplate template;
    MarsEnterpriseHandler handler = new MarsEnterpriseHandler(template);
   /*
   @Bean
   RouterFunction<ServerResponse> getEntRoute() {
        RouterFunction<ServerResponse> route = route()
                .POST("Mars/findByRequest", handler::findByRequest)
                .build();
        return route;
    }

    */
}
