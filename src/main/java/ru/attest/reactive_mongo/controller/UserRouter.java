package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.services.UserTemplate;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
@Deprecated
@Configuration(proxyBeanMethods = false)
public class UserRouter {
	@Autowired
	UserTemplate template;
	/*@Bean
	UserTemplate template(){
		return new UserTemplate();
	}

	 */
	/*@Bean
	public RouterFunction<ServerResponse> route(UserHandler userHandler) {

		return RouterFunctions
				.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON))
						, userHandler::hello);
	}
*/
	@Bean
	RouterFunction<ServerResponse> getAllUsersRoute() {
		//System.out.println("a");
		return route(GET("/users"),
				req -> ok().body(
						template.findAll(), User.class));
	}



}
