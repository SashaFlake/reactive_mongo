package ru.attest.reactive_mongo.util;

import org.bson.types.ObjectId;
import ru.attest.reactive_mongo.entities.MarsEnterprise;
import ru.attest.reactive_mongo.entities.enterprise.Conf;
import ru.attest.reactive_mongo.entities.enterprise.Timezone;
import ru.attest.reactive_mongo.entities.mars.enterprise.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

public class MarsEnterpriseFakeGenerator {
    public static MarsEnterprise randomMarsEnterprise(){
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
    public static String randomString(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.US_ASCII);
    }
    public static AddInfo createAddInfo(){
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
    public static Classificator randomClassificator(){
        return new Classificator(randomString(),randomString());
    }
    public static Subordination randomSubordination(){
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
    public static Communications randomCommunications(){
        return new Communications(randomString(),
                randomString(), randomString(),randomString(),
                randomString(),randomString());
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
    public static Position randomPosition(){
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
        employee.setConf(new Conf(randomString(), randomString(),
                randomString(), randomString()));
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
