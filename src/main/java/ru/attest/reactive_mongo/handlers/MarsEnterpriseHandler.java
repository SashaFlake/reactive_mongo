package ru.attest.reactive_mongo.handlers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;

@Component
public class MarsEnterpriseHandler {
    private final ReactiveMongoTemplate template;
    public MarsEnterpriseHandler(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public Mono<ServerResponse> findByRequest(ServerRequest request){
       //CustomFilter filter =
        Query query = new Query();
        Mono<FilterCollection> collectionMono = request.bodyToMono(FilterCollection.class);
        FilterCollection collection = new FilterCollection();
        CustomFilter customFilter = new CustomFilter();
        /*request.bodyToMono(FilterCollection.class)
                .map(
                        x->{
                            FilterCollection cf_ = new FilterCollection(
                            x.getFilters(),x.getCondition(),x.isCaseSensitive()
                            );
                            collection.setCondition(x.getCondition());
                            collection.setFilters(x.getFilters());
                            collection.setCaseSensitive(x.isCaseSensitive());
                            return x;
                        }
                );

         */
                //.map(
              //  x->{
                //    CustomFilter customFilter_ = new CustomFilter(
                  //          x.getField(), x.getValues(),x.getTypeComprason()
                //    );
                    //collection.getFilters().add(customFilter);
                    //query.addCriteria(TemplateCriteriaCommon.getCriteria(collection));
                   // return customFilter_;
            //    }
                // );

        //Mono<String> body = request.bodyToMono(String.class);

        collectionMono.subscribe(value ->
                query.addCriteria(Criteria.where(value.getFilters().get(0).getField())
                        .is(value.getFilters().get(0).getValues()))
                );
        collectionMono.subscribe(FilterCollection::toString);
        //return ServerResponse.ok().body(body,String.class);

        query.with(Pageable.ofSize(20).withPage(1));
        Flux<MarsEnterprise> found = template.find(query,MarsEnterprise.class);
        return ServerResponse.ok().body(found,MarsEnterprise.class);
    }
}
