package ru.attest.reactive_mongo.handlers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.City;
import ru.attest.reactive_mongo.entities.MetaModel;
import ru.attest.reactive_mongo.entities.Metaclass;
import ru.attest.reactive_mongo.entities.enterprise.*;
import ru.attest.reactive_mongo.entities.mars.enterprise.MarsEnterprise;
import ru.attest.reactive_mongo.services.MarsEnterpriseService;
import ru.attest.reactive_mongo.services.TemplateCriteriaCommon;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import org.springframework.data.mongodb.core.query.Query;
import ru.attest.reactive_mongo.util.TypeComparison;
import ru.attest.reactive_mongo.entities.enterprise.Enterprise;


import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

       // ru.attest.reactive_mongo.entities.enterprise.Enterprise ent = new Enterprise();
        Enterprise ent = new Enterprise();
        ent.setId(ObjectId.get());
        ent.setName("test");
        ent.setParentKey(null);
        ent.setOrd(0);
        ent.setShortName("tst");
        Conf conf = new Conf();
        conf.setName("открытый доступ");
        conf.setConfTypeDescription("описание");
        ent.setConfClassified(conf);
        ent.setFullName("test test");
        Timezone timezone = new Timezone();
        timezone.setTimeId("i");
        timezone.setName("+3");
        timezone.setTimeValue(1.00);
        Territory territory = new Territory();
        territory.setTerrid("Spb");
        territory.setName("Saint-Petersburg");
        territory.setOktmo("000");
        ent.setTimezone(timezone);
        ent.setCity(territory);
        ent.setTerName("spb");
        ent.setLatitude(0.00);
        ent.setLongitude(0.00);
        ent.setZoom(0.00);
        ent.setOpf("aaa");
        ent.setInn("aa");
        ent.setEntRequisite("aaa");
        ent.setInfConnCategory("aa");
        ent.setEconomyDep("aaa");
        ent.setDepComplex("aaa");
        ent.setIsExploitationEnt(false);
        ent.setIsYarooEnt(true);
        ent.setRegisterNum("aa");
        ent.setRegisterDate(LocalDateTime.now());
        ent.setRegisterAddress("ss");
        ent.setRadiationDanger("ss");
        ent.setNuclearDanger("aa");
        ent.setChemicalDanger("aa");
        ent.setChemicalDangerInfluenceCategory("aa");
        ent.setKeyId(BigDecimal.ONE);
        ent.setEnterpriseStruct("rrr");
        DepartmentType departmentType = new DepartmentType();
        departmentType.setGroupDepartmentType("aa");
        departmentType.setGroupDepartmentType("Aaa");
        ent.setDepartmentType(departmentType);
        Okved okved = new Okved();
        okved.setId("a");
        okved.setId("aa");
        ent.setOkvedSet(new ArrayList<>());
        ent.getOkvedSet().add(okved);
        ent.setDepartments(new ArrayList<>());
        Department department = new Department();
        department.setDepartmentType(departmentType);
        department.setContacts("a");
        department.setName("a");
        department.setShortName("aa");
        department.setOrd(1);
        department.setFullName("aaaaaaa");
        ent.getDepartments().add(department);
        //template.save(ent);
        return city.flatMap(user ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(template.save(ent), Enterprise.class));

    }
    public Mono<ServerResponse> createMarsEnt(ServerRequest request) {
        MarsEnterpriseService marsEnterpriseService = new MarsEnterpriseService(template);
        //marsEnterpriseService.create();
        return marsEnterpriseService.create();
    }
    public Mono<ServerResponse> viewAllMars(ServerRequest request){
        Query query = new Query();
        query.with(Pageable.ofSize(20).withPage(1));
        Flux<MarsEnterprise> found = template.find(query,MarsEnterprise.class);
        return ServerResponse.ok().body(found,MarsEnterprise.class);
    }

    public Mono<ServerResponse> view(ServerRequest request) {

            Mono<City> city = request.bodyToMono(City.class);
            //Criteria criteria = new Criteria().;
            Mono<City> bodyData;

         //   bodyData =
            //  request.bodyToMono(City.class);

          //  City fromBody;
            //        request.bodyToMono(City.class).map(new City());
            FilterCollection collection = new FilterCollection();
            collection.setCaseSensitive(false);
            collection.setCondition(0);
            CustomFilter filter = new CustomFilter();
            filter.setField("name");
            filter.setTypeComprason(TypeComparison.Equal);
            Mono<City> city_ = request.body(BodyExtractors.toMono(City.class));
             //City aA = null;
            //city_.doOnSuccess(x->x.getName());
           // String name = city.publish().
                    //.map(City::getName).doOnSuccess(a->System.out.println(a));
                 //   .block()
                 //   .toFuture().get()
                  //  .subscribe(String::valueOf);
            //filter.setValues(city_.block());
          //  bl().subscribe(x->filter.setField(x));
                    //bodyData.map(City::getCountry).subscribe());
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
