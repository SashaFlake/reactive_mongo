package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;
@Data
public class Conf {

    private String name;

    private String confTypeName;

    private String confTypeShortName;

    public String confTypeDescription;

    public Conf(String name, String confTypeName, String confTypeShortName, String confTypeDescription) {
        this.name = name;
        this.confTypeName = confTypeName;
        this.confTypeShortName = confTypeShortName;
        this.confTypeDescription = confTypeDescription;
    }

    public Conf() {
    }
}
