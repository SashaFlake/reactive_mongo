package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class Communications {
    private String type;
    private String system;
    private String number;
    private String add;
    private String conf;
    private String comment;

    public Communications(String type, String system, String number, String add, String conf, String comment) {
        this.type = type;
        this.system = system;
        this.number = number;
        this.add = add;
        this.conf = conf;
        this.comment = comment;
    }
}
