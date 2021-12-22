package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class ContactScc {
    private Employee employee;
    private String typeCommunication;
}
