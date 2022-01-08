package ru.attest.reactive_mongo.services;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.entities.mars.enterprise.*;
import ru.attest.reactive_mongo.util.CustomFilter;
import ru.attest.reactive_mongo.util.FilterCollection;
import ru.attest.reactive_mongo.util.FilterCondition;
import ru.attest.reactive_mongo.util.TypeComparison;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static ru.attest.reactive_mongo.util.MarsEnterpriseFakeGenerator.randomMarsEnterprise;

@Service
@Getter
public class MarsEnterpriseService {
    final private ReactiveMongoTemplate template;

    public MarsEnterpriseService(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public Mono<ServerResponse> create(){
        //Создаем случайные записи
        MarsEnterprise marsEnterprise = randomMarsEnterprise();
        template.save(marsEnterprise);
        return
                Mono.from(ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(template.save(marsEnterprise),MarsEnterprise.class));
    }

    public Mono<MarsEnterprise> createNewVersion(Mono<MarsEnterprise> oldEnterprise){

        //Создали новую версию из старой, старую сделаем архивной, новую сделаем с состоянием Редактирование
        Mono<MarsEnterprise> newEnterprise = Mono.just(new MarsEnterprise());
        //Скопируем свойства
        BeanUtils.copyProperties(oldEnterprise,newEnterprise);
        //Зададим новый id и состояние "Редактируется"
        newEnterprise = setNewVersion(newEnterprise);
        //Сделаем последнюю актуальную версию больше не актуальной
        setArchiveState(findActualVersion());

        return template.save(newEnterprise);
    }

    public Mono<MarsEnterprise> findActualVersion(){
        //Находим последнюю актуальную версию,
        // потому что создавать новую версию можно из архивной
        List<CustomFilter> filterList = new ArrayList<>();
        filterList.add(new CustomFilter("state",MarsEnterpriseState.Actual.getState(),TypeComparison.Equal));
        FilterCollection collection = new FilterCollection(
                filterList, FilterCondition.And.getKey(), false
        );
        Query query = new Query();

        query.addCriteria(TemplateCriteriaCommon.getCriteria(collection));

        return Mono.from(template.find(query, MarsEnterprise.class));
    }

    public Mono<MarsEnterprise> setNewVersion(Mono<MarsEnterprise> marsEnterpriseFlux){
        //Зададим новый Id для версии
        //Зададим состояние "Редактирование"
        return Mono.from(marsEnterpriseFlux).doOnSuccess(x->{
            x.setId(new ObjectId());
            x.setState(MarsEnterpriseState.Edited.getState());
                }
        );
    }

    public void setArchiveState(Mono<MarsEnterprise> oldVersion){
        //Зададим состояние архивной записи и сохраним
        oldVersion.map(x->{
            x.setState(MarsEnterpriseState.Archive.getState());
            return x;
                }).subscribe(template::save);
    }

    public Mono<MarsEnterprise> setActualVersion(Mono<MarsEnterprise> newVersion){
        return newVersion.map(x->{
            x.setState(MarsEnterpriseState.Actual.getState());
            x.setChangeDate(LocalDateTime.now());
            return x;
        });
    }

    public Mono<MarsEnterprise> rollbackEnterpriseVersion(Mono<MarsEnterprise> versionToRollback){
        return createNewVersion(versionToRollback);
    }
    public void approveVersion(Mono<MarsEnterprise> versionToApprove){
        //Сохраняем весрию как актуальную
        versionToApprove.map(x->{
            x.setState(MarsEnterpriseState.Actual.getState());
            return x;
        }).subscribe(template::save);
    }
}
