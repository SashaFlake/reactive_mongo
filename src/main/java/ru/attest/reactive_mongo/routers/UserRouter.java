package ru.attest.reactive_mongo.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.handlers.UserHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class UserRouter {
    @Autowired
    UserHandler handler;
    @Bean
    RouterFunction<ServerResponse> getUserRoute() {
        return RouterFunctions.route()
                .GET("/hello-world", accept(MediaType.TEXT_PLAIN),
                        request -> ServerResponse.ok().bodyValue("Hello World"))
                .GET("/showall", handler::all)
                .GET("createUser",handler::createUser)
                .build();
    }

}
