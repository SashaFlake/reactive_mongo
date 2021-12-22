package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Position {
    private String name;
    private String type;
    private String duties;
    private String supervisor;
    private String roomNumber;
    private Boolean showInPhoneBook;
    private List<Communications> communications = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
}
