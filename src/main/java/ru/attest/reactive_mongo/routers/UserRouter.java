package ru.attest.reactive_mongo.routers;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class UserRouter {
    RouterFunction<ServerResponse> route = RouterFunctions.route()
            .GET("/hello-world", accept(MediaType.TEXT_PLAIN),
                    request -> ServerResponse.ok().bodyValue("Hello World")).build();
}
