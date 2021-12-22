package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MarsDepartment {
    private String shortName;
    private String fullName;
    private String departmentType;
    private String description;
    private List<Communications> communications = new ArrayList<>();
    private List<Position> positions = new ArrayList<>();
}
