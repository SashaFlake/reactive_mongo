package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;
import ru.attest.reactive_mongo.entities.enterprise.Conf;
@Data
public class Address {
    private String type;
    private Conf conf;
    private String zip;
    private String country;
    private String region;
    private String district;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;
    private String additional;

}
