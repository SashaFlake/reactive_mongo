package ru.attest.reactive_mongo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Metaclass {
    @Id
    private String name;
    private String path;
    private List<MetaField> fields;
}
