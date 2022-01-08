package ru.attest.reactive_mongo.configuration;

import ch.qos.logback.core.encoder.EncoderBase;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class ReactiveMongoConfig  extends AbstractReactiveMongoConfiguration {
	@Autowired
	private Environment environment;
	@Value("${db_name}")
	private String dbName;
	@Value("${db_address}")
	private String dbAddress;
	@Value("${db_port}")
	private String dbPort;

	@Override
	protected String getDatabaseName() {
		//return environment.getProperty("db_name");
		return dbName;
	}
	protected String getAddress() {
		//return environment.getProperty("db_address");
		return dbAddress;
		//return "localhost";
	}
	protected String getPort() {
		//return environment.getProperty("db_port");
		return dbPort;
	}

	protected String getConnectionString(){
		return String.format("mongodb://%s:%s/%s",getAddress(),getPort(),getDatabaseName());
	}
	@Override
	public MongoClient reactiveMongoClient() {

		//ConnectionString connectionString = new ConnectionString("mongodb://fap9.krit.pro:27017/stat");
		//ConnectionString connectionString = new ConnectionString("mongodb://34.65.39.207:27017/stat");
		ConnectionString connectionString = new ConnectionString(getConnectionString());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate(){
		return new ReactiveMongoTemplate(reactiveMongoClient(),"stat_db");
	}
}
