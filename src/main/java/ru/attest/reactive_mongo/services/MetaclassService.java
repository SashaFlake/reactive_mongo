package ru.attest.reactive_mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.City;
import ru.attest.reactive_mongo.entities.Metaclass;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import ru.attest.reactive_mongo.util.TypeComparison;

import java.util.ArrayList;
import java.util.List;

public class MetaclassService {
    @Autowired
    ReactiveMongoTemplate template;
    public Flux<City> findByPred() {
        Query query = new Query();
        FilterCollection collection = new FilterCollection();
        collection.setCaseSensitive(false);
        collection.setCondition(0);
        CustomFilter filter = new CustomFilter();
        filter.setField("name");
        filter.setTypeComprason(TypeComparison.Equal);
        filter.setValues("Pas de la Casa");
        List<CustomFilter> filterList = new ArrayList<>();
        filterList.add(filter);
        collection.setFilters(filterList);

        query.addCriteria(TemplateCriteriaCommon.getCriteria(collection));
        Pageable pageable = PageRequest.of(0,20);
        query.with(pageable);
        return template.find(query,City.class);
    }

    public Flux<Metaclass> findByAll(){
        return template.findAll(Metaclass.class);
    }

    public void save(Metaclass metaclass){
        template.save(metaclass);
    }
}
