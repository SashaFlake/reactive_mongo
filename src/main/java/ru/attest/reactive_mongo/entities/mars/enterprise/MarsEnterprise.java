package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.attest.reactive_mongo.entities.AbstractEntity;
import ru.attest.reactive_mongo.entities.enterprise.Conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Document
public class MarsEnterprise extends AbstractEntity {
    private String shortName;
    private String engName;
    private Conf confidential;
    private Boolean liquidated;
    private Location location;
    private Coordinates coordinates;
    private String principle;
    private String position;
    private List<Communications> principleCommunication = new ArrayList<>();
    private List<Communications> orgCommunication = new ArrayList<>();
    private Map<String,String> vals;
    private AddInfo addInfo;
    private Subordination subordination;
    private Structure structure;
    private List<ContactScc> contactSccList;
    private SpecialService specialService;
}
