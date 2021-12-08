package ru.attest.reactive_mongo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.handlers.UserHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class UserRouter {
	@Bean
	public RouterFunction<ServerResponse> route(UserHandler userHandler) {

		return RouterFunctions
				.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON))
						, userHandler::hello);
	}
}
