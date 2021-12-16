package ru.attest.reactive_mongo.entities;

import lombok.Data;

@Data
public class MetaField {
    private String name;
    private MetaAnnotation annotation = new MetaAnnotation();
}
