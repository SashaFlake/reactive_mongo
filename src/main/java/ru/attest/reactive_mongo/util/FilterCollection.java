package ru.attest.reactive_mongo.util;

import lombok.Data;

import java.util.List;
@Data
public class FilterCollection {
	public List<CustomFilter> filters;
	public Integer condition;
	public boolean caseSensitive;

}


