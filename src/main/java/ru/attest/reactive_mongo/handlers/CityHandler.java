package ru.attest.reactive_mongo.handlers;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.City;
import ru.attest.reactive_mongo.entities.MetaModel;
import ru.attest.reactive_mongo.entities.enterprise.*;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.services.MarsEnterpriseService;
import ru.attest.reactive_mongo.services.TemplateCriteriaCommon;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import org.springframework.data.mongodb.core.query.Query;
import ru.attest.reactive_mongo.util.TypeComparison;
import ru.attest.reactive_mongo.entities.enterprise.Enterprise;


import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        return city.flatMap(response ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(template.save(city), Enterprise.class));

    }

    public Mono<ServerResponse> createMarsEnt(ServerRequest request) {
        MarsEnterpriseService marsEnterpriseService = new MarsEnterpriseService(template);
        //marsEnterpriseService.create();
        return marsEnterpriseService.create();
    }

    public Mono<ServerResponse> viewAllMars(ServerRequest request){
        //Если я создаю query я блокирую ввод
        Query query = new Query();
        query.with(Pageable.ofSize(1000).withPage(0));
        Flux<MarsEnterprise> found = template.find(query,MarsEnterprise.class);
        return ServerResponse.ok().body(found,MarsEnterprise.class);
    }

    public Mono<ServerResponse> view(ServerRequest request) {

            Mono<City> city = request.bodyToMono(City.class);
            Mono<City> bodyData;

            FilterCollection collection = new FilterCollection();
            collection.setCaseSensitive(false);
            collection.setCondition(0);
            CustomFilter filter = new CustomFilter();
            filter.setField("name");
            filter.setTypeComparison(TypeComparison.Equal);
            Mono<City> city_ = request.body(BodyExtractors.toMono(City.class));
            List<CustomFilter> filterList = new ArrayList<>();
            filterList.add(filter);
            collection.setFilters(filterList);
            Query query = new Query();

            query.addCriteria(TemplateCriteriaCommon.getCriteria(collection));


            MetaModel metaModel = new MetaModel();


            // .toFuture().get(5, TimeUnit.SECONDS);
            /*
                    .share().subscribe(
                            x-> new City(x.getId(),x.getName(),x.getCountry(),x.getLat(),x.getLng())
                    );


                     */
            //bodyData.subscribe(x->x.getCountry())
            //String a = bodyData.subscribe(result -> result.getCountry());

                    //.doOnNext(x->x.getCountry()).subscribe()
            Flux<City> found = template.find(query,City.class);
            return ServerResponse.ok().body(found,City.class);
                  /*  city.flatMap(user ->
                    ServerResponse.status(HttpStatus.CREATED)
                            .contentType(APPLICATION_JSON)
                            .body(template.save(user),Metaclass.class)
            );

                   */
                   // ServerResponse.ok().build();

           /* metaModel.setMeta(template.find(query,Metaclass.class).subscribe(){
                x ->
            });


            return city.flatMap(user ->
                    ServerResponse.status(HttpStatus.CREATED)
                            .contentType(APPLICATION_JSON)
                            .body(template.save(user),Metaclass.class)
            );

            */
        // return ok().build(temp late.save(metaclass));
    }

    public Mono<String> bl(){
        return Mono.just("Sant Julià de Lòria");
    }
}
