package ru.attest.reactive_mongo.handlers;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.City;
import ru.attest.reactive_mongo.entities.MetaModel;
import ru.attest.reactive_mongo.entities.Metaclass;
import ru.attest.reactive_mongo.services.TemplateCriteriaCommon;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import org.springframework.data.mongodb.core.query.Query;
import ru.attest.reactive_mongo.util.TypeComparison;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class CityHandler {
    ReactiveMongoTemplate template;

    public CityHandler(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public CityHandler() {
    }

    public Mono<ServerResponse> listMetaclass(ServerRequest request) {
        Flux<FilterCollection> filterCollection = request.bodyToFlux(FilterCollection.class);
        return null;
    }

    public Mono<ServerResponse> createCity(ServerRequest request) {
        Mono<City> city = request.bodyToMono(City.class);

        return city.flatMap(user ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(template.save(user),Metaclass.class)
        );
        public Mono<ServerResponse> view(ServerRequest request) {
           // Mono<City> city = request.bodyToMono(City.class);
            Criteria criteria = new Criteria().;
            FilterCollection collection = new FilterCollection();
            collection.setCaseSensitive(false);
            collection.setCondition(0);
            CustomFilter filter = new CustomFilter();
            filter.setField("name");
            filter.setTypeComprason(TypeComparison.Equal);
            filter.setValues("City");
            List<CustomFilter> filterList = new ArrayList<>();
            filterList.add(filter);
            collection.setFilters(filterList);
            Query query = new Query();

            query.addCriteria(TemplateCriteriaCommon.getCriteria(collection));


            MetaModel metaModel = new MetaModel();
            metaModel.setMeta(template.find(query,Metaclass.class).subscribe(){
                x ->
            });
            return city.flatMap(user ->
                    ServerResponse.status(HttpStatus.CREATED)
                            .contentType(APPLICATION_JSON)
                            .body(template.save(user),Metaclass.class)
            );
        // return ok().build(temp late.save(metaclass));
    }
}
