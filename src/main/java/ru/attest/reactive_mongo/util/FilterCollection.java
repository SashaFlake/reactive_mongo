package ru.attest.reactive_mongo.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class FilterCollection {
	public List<CustomFilter> filters = new ArrayList<>();
	public Integer condition;
	public boolean caseSensitive;

	public FilterCollection(List<CustomFilter> filters, Integer condition, boolean caseSensitive) {
		this.filters = filters;
		this.condition = condition;
		this.caseSensitive = caseSensitive;
	}
}


