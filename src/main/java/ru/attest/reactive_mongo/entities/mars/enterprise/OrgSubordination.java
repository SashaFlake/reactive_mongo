package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class OrgSubordination {
    private String type;
    private String ministry;
    private String ministryDepartment;
    private String headOrganization;
    private String organization;
    private String division;
    private String managingCompany;

    public OrgSubordination(String type, String ministry, String ministryDepartment,
                            String headOrganization, String organization,
                            String division, String managingCompany) {
        this.type = type;
        this.ministry = ministry;
        this.ministryDepartment = ministryDepartment;
        this.headOrganization = headOrganization;
        this.organization = organization;
        this.division = division;
        this.managingCompany = managingCompany;
    }
}
