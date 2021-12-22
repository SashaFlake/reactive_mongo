package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Subordination {
    private Boolean isHeadOrganization;
    private OrgSubordination orgSubordination;
    private String managementContour;
    private String communicationRegulations;
    private Curator curator;
    private List<String> childIds = new ArrayList<>();
}
