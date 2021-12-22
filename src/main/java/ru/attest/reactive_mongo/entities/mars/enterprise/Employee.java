package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;
import ru.attest.reactive_mongo.entities.enterprise.Conf;

import java.util.ArrayList;
import java.util.List;
@Data
public class Employee {
    private String name;
    private String description;
    private Conf conf;
    private List<Communications> communications = new ArrayList<>();
}
