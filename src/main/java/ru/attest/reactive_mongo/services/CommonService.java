package ru.attest.reactive_mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.attest.reactive_mongo.util.FilterCollection;
@Service
public class CommonService {
    @Autowired
    ReactiveMongoTemplate template;
    public <T> Flux<T> findByPredicates(FilterCollection filterCollection, Class<T> T){
        Query query = new Query();
        //Заполним фильтры из body запроса
        query.addCriteria(TemplateCriteriaCommon.getCriteria(filterCollection));
        //Пагинация первые 20, начиная с 0 страницы
        query.with(Pageable.ofSize(20).withPage(0));

        return template.find(query,T);
    }
}
