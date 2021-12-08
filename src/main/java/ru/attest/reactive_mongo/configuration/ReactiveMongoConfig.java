package ru.attest.reactive_mongo.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class ReactiveMongoConfig  extends AbstractReactiveMongoConfiguration {
	@Override
	protected String getDatabaseName() {
		return "stat";
	}

	@Override
	public MongoClient reactiveMongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://fap9.krit.pro:27017/stat");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate(){
		return new ReactiveMongoTemplate(reactiveMongoClient(),"stat");
	}
}
