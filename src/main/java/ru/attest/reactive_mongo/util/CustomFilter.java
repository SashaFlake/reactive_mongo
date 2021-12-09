package ru.attest.reactive_mongo.util;

import lombok.Data;

@Data
public class CustomFilter {
	private String field;
	private Object values;
	private TypeComparison typeComprason;
}
