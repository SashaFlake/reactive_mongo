package ru.attest.reactive_mongo.services;

import org.springframework.data.mongodb.core.query.Criteria;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import ru.attest.reactive_mongo.util.TypeComparison;

import java.util.ArrayList;
import java.util.List;

public class TemplateCriteriaCommon {

	public static Criteria getCriteria(FilterCollection filterCollection){
		List<Criteria> criteriaList = new ArrayList<>();
		Criteria finalCr = new Criteria().all();

		for(CustomFilter filter_:filterCollection.getFilters()){
			String field = filter_.getField();
			Object value = filter_.getValues();
			TypeComparison comparison = filter_.getTypeComprason();
			if(filterCollection.getCondition().equals(0)){
				//finalCr.andOperator(getComparison(comparison,field,value));
				finalCr = getComparison(comparison,field,value);
			}
		}
		return finalCr;
		/*for(String field:fields){
			criteriaList.add(Criteria.where(field).is("Mellbourn"));
		}
		return criteriaList;
		Criteria.where().and().

	 */
	}
	public static Criteria getComparison(TypeComparison typeComparison, String field, Object value){
		Criteria criteria = Criteria.where(field);

		switch( typeComparison.getKey()) {
			case (0) -> criteria.isNull();
			case (1) -> criteria.is(value);
			case (2) -> criteria.not().is(value);
			case (3) -> criteria.lt(value);
			case (4) -> criteria.gt(value);
			case (5) -> criteria.lte(value);
			case (6) -> criteria.gte(value);
			case (7) -> criteria.regex(".*"+value+".*","i");
			case (8) -> criteria.not().regex(".*"+value+".*","i");
			case (9) -> criteria.in(value);
			case (10) -> criteria.not().in(value);
			case (11) -> criteria.not().isNull();
			//case (13): //-> criteria.gte(Integer.valueOf(value.split(",")[0]))
				//	predicate = cb.between(expression,filter.value,val2)
				//Integer val1  = Integer.valueOf(filter.value.split(",")[0]);
				//	Integer val2  = Integer.valueOf(filter.value.split(",")[1]);
				//predicate =	cb.between(expression, val1, val2);
				//break;
			case 20, 21 -> criteria.is(true);
				/*if(dynamic && !isBoolean){
					predicate = checkForNullValue(cb,cb.lower(expression),((Boolean)(filter.getTypeComparison().getKey()==20)).toString().toLowerCase(),false);
				}else{
					predicate = checkForNullValue(cb,expression,filter.getTypeComparison().getKey()==20,false);
				}

				 */
				//break;
			//default: criteria.is(value);
				//predicate = null;
		}
		return criteria;
	}

}
