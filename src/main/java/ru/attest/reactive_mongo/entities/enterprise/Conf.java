package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;
@Data
public class Conf {

    private String name;

    private String confTypeName;

    private String confTypeShortName;

    public String confTypeDescription;

}
