package ru.attest.reactive_mongo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class City {

	@Id
	private String id;
	private String name;
	private String country;
}
