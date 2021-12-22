package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class Dangers {
    private String radiation;
    private String nuclear;
    private String chemicalObjects;
    private String chemicalPeople;

    public Dangers(String radiation, String nuclear, String chemicalObjects, String chemicalPeople) {
        this.radiation = radiation;
        this.nuclear = nuclear;
        this.chemicalObjects = chemicalObjects;
        this.chemicalPeople = chemicalPeople;
    }
}
