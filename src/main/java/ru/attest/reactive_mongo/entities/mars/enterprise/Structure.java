package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;
import ru.attest.reactive_mongo.entities.enterprise.Department;

import java.util.ArrayList;
import java.util.List;
@Data
public class Structure {
    private List<MarsDepartment> departments = new ArrayList<>();
}
