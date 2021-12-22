package ru.attest.reactive_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.attest.reactive_mongo.entities.User;
import ru.attest.reactive_mongo.handlers.CityHandler;
import ru.attest.reactive_mongo.handlers.MetaclassHandler;
import ru.attest.reactive_mongo.services.CityService;
import ru.attest.reactive_mongo.services.UserTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration(proxyBeanMethods = false)
public class CityRouter {
	@Autowired
	ReactiveMongoTemplate template;
	@Bean
	RouterFunction<ServerResponse> getCityRoute() {
	/*	RouterFunction<ServerResponse> route = route()
				.GET("/cities", accept(APPLICATION_JSON), handler::getPerson)
				.GET("/person", accept(APPLICATION_JSON), handler::listPeople)
				.POST("/person", handler::createPerson)
				.add(otherRoute)
				.build();

	 */
		//request.
		/*return route(GET("/cities"),
				req -> ok().body(
						//template.findByPred(), User.class)
						//req -> ok().
						template.findByAll(), User.class)


				);


		 */
		CityHandler handler = new CityHandler(template);
		RouterFunction<ServerResponse> route = route()
				// .GET("/person/{id}", accept(APPLICATION_JSON), handler::getPerson)
				// .GET("/person", accept(APPLICATION_JSON), handler::listPeople)
				.POST("/City/Create", handler::createCity)
				.POST("/City/View", handler::view)
				.POST("MarsEnt",handler::createMarsEnt)
				.build();
		return route;
								//.findAll(), User.class));

	}
}
