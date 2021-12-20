package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;

@Data
public class Department {

    private String name;

    private String parent;

    private int ord;

    private String shortName;

    private String fullName;

    private DepartmentType departmentType;

    private String contacts;

}
