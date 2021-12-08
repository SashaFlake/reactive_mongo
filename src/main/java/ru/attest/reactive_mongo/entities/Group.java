package ru.attest.reactive_mongo.entities;

import lombok.Data;

import java.util.BitSet;

@Data
public class Group {
	private String group;

	public Group(String name) {
		this.group = name;
	}

	public Group() {
	}
}
