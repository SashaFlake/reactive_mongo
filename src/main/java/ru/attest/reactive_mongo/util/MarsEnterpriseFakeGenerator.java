package ru.attest.reactive_mongo.util;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.entities.enterprise.Conf;
import ru.attest.reactive_mongo.entities.enterprise.Timezone;
import ru.attest.reactive_mongo.entities.mars.enterprise.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

public class MarsEnterpriseFakeGenerator {
    static Faker faker = new Faker();
    public static MarsEnterprise randomMarsEnterprise(){
        MarsEnterprise marsEnterprise = new MarsEnterprise();
        marsEnterprise.setId(ObjectId.get());
        marsEnterprise.setName(randomCompanyName());
        marsEnterprise.setShortName(randomCompanyName());
        marsEnterprise.setEngName(randomCompanyName());
        marsEnterprise.setConfidential(new Conf("открытый доступ","ОД",
                "ОД","ОД"));
        marsEnterprise.setLiquidated(false);
        marsEnterprise.setLocation(new Location(faker.address().country(),
                faker.address().state(),faker.address().state(),faker.address().city(),
                new Timezone("+3","=3",3D)));
        marsEnterprise.setCoordinates(new Coordinates(3D,2D));
        marsEnterprise.setPrinciple(randomPersonName());
        marsEnterprise.setPosition(faker.company().profession());

        Communications princ = new Communications("phone",
                faker.phoneNumber().extension(), faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().extension(),"OD","AAAAAAAAAAAAAAA");
        for(int i=0;i< 5;i++) {
            marsEnterprise.getOrgCommunication().add(princ);
            marsEnterprise.getPrincipleCommunication().add(princ);
        }

        marsEnterprise.setAddInfo(createAddInfo());
        marsEnterprise.setSubordination(randomSubordination());
        marsEnterprise.setStructure(randomStructure());
        return marsEnterprise;
    }
    public static String randomCompanyName(){
        return faker.company().name();
    }
    public static String randomPersonName(){

        Faker faker = new Faker();
        return faker.funnyName().name();
    }
    public static AddInfo createAddInfo(){
        AddInfo addInfo =new AddInfo();
        addInfo.setLegalForm("ОПФ");
        addInfo.setTaxNumber(faker.number().digits(5));
        addInfo.setPaymentInfo(faker.address().fullAddress());
        addInfo.setCatInformationExchange(faker.starTrek().character());
        addInfo.setEconomyBranch(faker.company().industry());
        addInfo.setBranchComplex(faker.company().industry());
        addInfo.setIsExplotationOrg(true);
        addInfo.setIsExplotationOrg(true);
        addInfo.setShowInPPD(true);
        addInfo.setActivities(faker.company().industry());
        addInfo.setActivitiesDescription(faker.company().industry());
        addInfo.setRegistryNumber(faker.number().digits(10));
        addInfo.setRegistryDate(new Date());
        addInfo.setRegistryLocation(faker.address().city());
        for(int cl=0;cl<faker.number().numberBetween(0,5);cl++) {
            addInfo.getClassificators().add(randomClassificator());
        }
        addInfo.setDangers(new Dangers(faker.funnyName().name(),faker.funnyName().name()
                ,faker.funnyName().name(),faker.funnyName().name()));
        addInfo.setActivities(faker.funnyName().name());
        return addInfo;
    }
    public static Classificator randomClassificator(){
        return new Classificator(faker.company().industry(),faker.company().industry());
    }
    public static Subordination randomSubordination(){
        Subordination subordination = new Subordination();
        subordination.setOrgSubordination(new OrgSubordination(
                faker.company().name(),faker.company().name(),
                faker.company().name(),faker.company().name(),
                faker.company().name(),faker.company().name(),faker.company().name()
        ));
        subordination.setCommunicationRegulations(faker.company().name());
        subordination.setIsHeadOrganization(true);
        subordination.setManagementContour(faker.company().name());
        /*subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());
        subordination.getChildIds().add(randomString());

         */
        return subordination;
    }
    public static Communications randomCommunications(){
        return new Communications(faker.company().name(),
                faker.company().name(),faker.company().name(),faker.company().name(),
                faker.company().name(),faker.company().name());
    }
    public static Structure randomStructure(){
        Structure structure = new Structure();
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        structure.getDepartments().add(randomDepartment());
        return structure;
    }
    public static MarsDepartment randomDepartment(){
        MarsDepartment marsDepartment = new MarsDepartment();
        marsDepartment.setDepartmentType(faker.company().industry());
        marsDepartment.setDescription(faker.company().industry());
        marsDepartment.setFullName(faker.company().name());
        marsDepartment.setShortName(faker.company().name());
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
    public static Position randomPosition(){
        Position position = new Position();
        position.setName(faker.company().profession());
        position.setRoomNumber(String.valueOf(faker.number().numberBetween(0,10)));
        position.setDuties(faker.funnyName().name());
        position.setType(faker.funnyName().name());
        position.setSupervisor(faker.funnyName().name());
        position.getCommunications().add(randomCommunications());
        position.getCommunications().add(randomCommunications());
        position.getCommunications().add(randomCommunications());
        position.getEmployees().add(randomEmployee());
        position.getEmployees().add(randomEmployee());
        position.getEmployees().add(randomEmployee());
        position.getEmployees().add(randomEmployee());
        position.getEmployees().add(randomEmployee());
        position.getEmployees().add(randomEmployee());
        return position;
    }
    public static Employee randomEmployee() {
        Employee employee = new Employee();
        employee.setConf(new Conf(faker.space().agency(), faker.space().agency(),
                faker.space().agency(), faker.space().agency()));
        employee.setName(faker.funnyName().name());
        employee.setDescription(faker.funnyName().name());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        employee.getCommunications().add(randomCommunications());
        return employee;
    }
}
