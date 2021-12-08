package ru.attest.reactive_mongo.entities;

import lombok.Data;
import org.bson.BSONEncoder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
public class User implements Serializable {
	@Id
	private String id;
	private String password;
	private List<Group> groups;

	public User(String id) {
		this.id = id;
		this.password="test";
	}

	public User(String id, String password, List<Group> groups) {
		this.id = id;
		this.password = password;
		this.groups = groups;
	}

	public User() {
	}
}
