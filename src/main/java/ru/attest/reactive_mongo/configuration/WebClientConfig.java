package ru.attest.reactive_mongo.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;
import ru.attest.reactive_mongo.entities.User;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {
	//WebClient client = WebClient.create("http://localhost:8080/User/Save");
	//Mono<User> userMono = client.get().retrieve().bodyToMono(User.class);
	//String auth = environment.getProperty("authorizationAddress");

	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
	public static final int TIMEOUT = 1000;

	@Bean
	public WebClient webClientWithTimeout() {
		final var tcpClient = TcpClient
				.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
				.doOnConnected(connection -> {
					connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
					connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
				});
		return null;
	}
}