package ru.attest.reactive_mongo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "cities")
@Data
public class City {

	@Id
	private ObjectId id;
	private String name;
	private String country;
	private String lat;
	private String lng;

}
