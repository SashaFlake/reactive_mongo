package ru.attest.reactive_mongo.services;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.attest.reactive_mongo.entities.enterprise.Conf;
import ru.attest.reactive_mongo.entities.enterprise.Department;
import ru.attest.reactive_mongo.entities.enterprise.Enterprise;
import ru.attest.reactive_mongo.entities.enterprise.Timezone;
import ru.attest.reactive_mongo.entities.mars.enterprise.*;

import java.nio.charset.Charset;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;
@Service
@Getter
public class MarsEnterpriseService {
    private ReactiveMongoTemplate template;

    public MarsEnterpriseService(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public Mono<ServerResponse> create(){
        /*for(int i = 0;i<5000;i++) {
           template.save(randomMarsEnterprise());
        }

         */
        MarsEnterprise marsEnterprise = randomMarsEnterprise();
        //marsEnterprise = randomMarsEnterprise();
      //  String ok = "ok";
        return
                Mono.from(ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                               // .body(ok,String.class));
                        .body(template.save(marsEnterprise),MarsEnterprise.class));

    }

    public MarsEnterprise randomMarsEnterprise(){
        MarsEnterprise marsEnterprise = new MarsEnterprise();
        marsEnterprise.setId(ObjectId.get());
        marsEnterprise.setName(randomString());
        marsEnterprise.setShortName(randomString());
        marsEnterprise.setEngName(randomString());
        marsEnterprise.setConfidential(new Conf("открытый доступ","ОД",
                "ОД","ОД"));
        marsEnterprise.setLiquidated(false);
        marsEnterprise.setLocation(new Location("Россия","ЦФО","Московская область","Кропотня",
                new Timezone("+3","=3",3D)));
        marsEnterprise.setCoordinates(new Coordinates(3D,2D));
        marsEnterprise.setPrinciple("Иванов");
        marsEnterprise.setPosition("Директор");

        Communications princ = new Communications("phone",
                "+7999", "+888","aaa","OD","AAAAAAAAAAAAAAA");
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getOrgCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.getPrincipleCommunication().add(princ);
        marsEnterprise.setAddInfo(createAddInfo());
        marsEnterprise.setSubordination(randomSubordination());
        marsEnterprise.setStructure(randomStructure());
        return marsEnterprise;
    }
    public String randomString(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
    public AddInfo createAddInfo(){
        AddInfo addInfo =new AddInfo();
        addInfo.setLegalForm("ОПФ");
        addInfo.setTaxNumber(randomString());
        addInfo.setPaymentInfo(randomString());
        addInfo.setCatInformationExchange(randomString());
        addInfo.setEconomyBranch(randomString());
        addInfo.setBranchComplex(randomString());
        addInfo.setIsExplotationOrg(true);
        addInfo.setIsExplotationOrg(true);
        addInfo.setShowInPPD(true);
        addInfo.setActivities(randomString());
        addInfo.setActivitiesDescription(randomString());
        addInfo.setRegistryNumber(randomString());
        addInfo.setRegistryDate(new Date());
        addInfo.setRegistryLocation(randomString());
        addInfo.getClassificators().add(randomClassificator());
        addInfo.getClassificators().add(randomClassificator());
        addInfo.getClassificators().add(randomClassificator());
        addInfo.getClassificators().add(randomClassificator());
        addInfo.getClassificators().add(randomClassificator());
        addInfo.setDangers(new Dangers(randomString(),randomString()
                ,randomString(),randomString()));
        addInfo.setActivities(randomString());
        return addInfo;
    }
    public Classificator randomClassificator(){
        return new Classificator(randomString(),randomString());
    }
    public Subordination randomSubordination(){
        Subordination subordination = new Subordination();
        subordination.setOrgSubordination(new OrgSubordination(
                randomString(),randomString(),randomString(),randomString(),
                randomString(),randomString(),randomString()
        ));
        subordination.setCommunicationRegulations(randomString());
        subordination.setIsHeadOrganization(true);
        subordination.setManagementContour(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        return subordination;
    }
    public Communications randomCommunications(){
        return new Communications(randomString(),
                randomString(), randomString(),randomString(),
                randomString(),randomString());
    }
    public Structure randomStructure(){
        Structure structure = new Structure();
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        return structure;
    }
    public MarsDepartment randomDepartment(){
        MarsDepartment marsDepartment = new MarsDepartment();
        marsDepartment.setDepartmentType(randomString());
        marsDepartment.setDescription(randomString());
        marsDepartment.setFullName(randomString());
        marsDepartment.setShortName(randomString());
        marsDepartment.getCommunications().add(randomCommunications());
        marsDepartment.getCommunications().add(randomCommunications());
        marsDepartment.getCommunications().add(randomCommunications());
        marsDepartment.getCommunications().add(randomCommunications());
        marsDepartment.getCommunications().add(randomCommunications());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        marsDepartment.getPositions().add(randomPosition());
        return marsDepartment;
    }
    public Position randomPosition(){
        Position position = new Position();
        position.setName(randomString());
        position.setRoomNumber(randomString());
        position.setDuties(randomString());
        position.setType(randomString());
        position.setDuties(randomString());
        position.setSupervisor(randomString());
        position.getCommunications().add(randomCommunications());
        position.getCommunications().add(randomCommunications());
        position.getCommunications().add(randomCommunications());
        position.getEmployees().add(randomEmploee());
        position.getEmployees().add(randomEmploee());
        position.getEmployees().add(randomEmploee());
        position.getEmployees().add(randomEmploee());
        position.getEmployees().add(randomEmploee());
        position.getEmployees().add(randomEmploee());
        return position;
    }
    public Employee randomEmploee(){
        Employee employee = new Employee();
        employee.setConf(new Conf(randomString(),randomString(),
                randomString(),randomString()));
        employee.setName(randomString());
        employee.setDescription(randomString());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        return employee;
    }
}
