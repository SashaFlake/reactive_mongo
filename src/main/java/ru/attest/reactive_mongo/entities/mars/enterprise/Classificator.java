package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class Classificator {
    private String name;
    private String code;

    public Classificator(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
