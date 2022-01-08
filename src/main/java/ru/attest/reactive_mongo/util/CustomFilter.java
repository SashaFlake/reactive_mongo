package ru.attest.reactive_mongo.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomFilter {
	private String field;
	private Object values;
	private TypeComparison typeComparison;

	public CustomFilter(String field, Object values, TypeComparison typeComprason) {
		this.field = field;
		this.values = values;
		this.typeComparison = typeComprason;
	}
}
