package ru.attest.reactive_mongo.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class AbstractEntity implements MetaclassInfo{
	@Id
	private ObjectId id;
	private String name;

	public Flux<Metaclass> setMetaclass(){
		Metaclass metaclass = new Metaclass();
		metaclass.setName(this.getClass().getName());
		List<Field> fields = Arrays.stream(this.getClass().getFields()).toList();

		fields.forEach(
				field -> {
					MetaField metaField = new MetaField();
					metaField.setName(field.getName());
					metaclass.getFields().add(metaField);
				}
		);
		return Flux.just(metaclass);
	}
	public Flux<Metaclass> getMetaclass(ReactiveMongoTemplate template){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(this.getName()));
		return template.find(query,Metaclass.class);
	}
}
